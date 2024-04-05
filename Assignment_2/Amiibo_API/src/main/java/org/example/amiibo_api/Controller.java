package org.example.amiibo_api;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import java.io.IOException;
import java.util.Objects;
import java.util.TreeSet;


public class Controller {
    public TextField searchTextField;
    public ListView<releaseDate> dateLabel;
    public Label characterLabel;
    public Label gameLabel;
    public Label amiiboLabel;
    public Label seriesLabel;
    public Button searchButton;
    public HBox hBox;
    @FXML
    private ListView<Amiibo> listView;
    @FXML
    private ImageView imageView;
    @FXML
    private void initialize() throws IOException, InterruptedException {
        hBox.setVisible(true);

        searchAmiibos(new ActionEvent()); // Call searchAmiibos with an empty ActionEvent

        listView.getSelectionModel()
                .selectedItemProperty()
                .addListener((obs, oldValue, amiiboSelected) -> {
                    if (amiiboSelected != null) {
                        try {
                            imageView.setImage(new Image(amiiboSelected.getImage()));
                            seriesLabel.setText(amiiboSelected.getAmiiboSeries());
                            amiiboLabel.setText(amiiboSelected.getName());
                            gameLabel.setText(amiiboSelected.getGameSeries());
                            characterLabel.setText(amiiboSelected.getCharacter());
                            dateLabel.getItems().clear();
                            dateLabel.getItems().add(amiiboSelected.getRelease());
                        } catch (IllegalArgumentException e) {
                            imageView.setImage(new Image(Objects.requireNonNull(Application.class.getResourceAsStream("images/default.png"))));
                        }
                    }
                });
        searchTextField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                try {
                    searchAmiibos(new ActionEvent());
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace(); // Handle exception appropriately
                }
            }
        });
        listView.getSelectionModel().selectFirst();
    }
    @FXML
    private void searchAmiibos(ActionEvent event) throws IOException, InterruptedException {
        String gameSeries = searchTextField.getText().trim();
        startingAPI APIresult = API.callAPI(gameSeries);

        if (APIresult.getAmiibos() != null)
        {
            listView.getItems().clear();
            listView.getItems().addAll(APIresult.getAmiibos());

            TreeSet<Amiibo> sortedMovieSet = new TreeSet<>(listView.getItems());
            System.out.println(Integer.toString(sortedMovieSet.size()) + sortedMovieSet);
        }
    }
}