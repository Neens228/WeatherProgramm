package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

public class PleaseProvideControllerClassName {

    Image imageEarth = new Image("https://cdn-icons-png.flaticon.com/128/814/814587.png");

    Image imageAmerica = new Image("https://cdn-icons-png.flaticon.com/128/3654/3654976.png");

    Image imageMoscow = new Image("https://cdn-icons-png.flaticon.com/128/3654/3654934.png");

    Image imageMadrid = new Image("https://cdn-icons-png.flaticon.com/128/6582/6582786.png");

    Image imageEkb = new Image("https://cdn-icons-png.flaticon.com/128/1354/1354522.png");

    Image imageLondon = new Image("https://cdn-icons-png.flaticon.com/128/804/804380.png");

    Image imageSnow = new Image("https://cdn-icons-png.flaticon.com/128/2465/2465979.png");

    Image imageClear = new Image("https://cdn-icons-png.flaticon.com/128/3222/3222794.png");

    Image imageCloudy = new Image("https://cdn-icons-png.flaticon.com/128/2930/2930014.png");

    Image imageOvercast = new Image("https://cdn-icons-png.flaticon.com/128/3920/3920590.png");

    Image imageSunny = new Image("https://cdn-icons-png.flaticon.com/128/3222/3222672.png");

    Image imageRain = new Image("https://cdn-icons-png.flaticon.com/128/3313/3313888.png");

    Image imageParis = new Image("https://cdn-icons-png.flaticon.com/128/2697/2697619.png");

    String underline = " ";

    @FXML
    private Button ButtonF = new Button("F");

    @FXML
    private ProgressBar ProgressBar = new ProgressBar(0.4);

    @FXML
    private Text SpeedOfWind = new Text("SpeedOfWind");

    @FXML
    private Button ButtonLondon = new Button("London");

    @FXML
    private Button ButtonMadrid= new Button("Madrid");

    @FXML
    private Button ButtonWashington = new Button("washington ");

    @FXML
    private Button ButtonYekaterinburg = new Button("Yekaterinburg");

    @FXML
    private Text City = new Text("Moscow");

    @FXML
    private Text FeelsLike;

    @FXML
    private ProgressIndicator Humidity = new ProgressIndicator(20);

    @FXML
    private Button MoscowButton = new Button("Moscow");

    @FXML
    private Button ParisButton = new Button("Paris");

    @FXML
    private Text SkorostVetra = new Text();

    @FXML
    private Text Sunny;

    @FXML
    private Text Degrees = new Text("Degrees");

    @FXML
    private Text Time = new Text();

    @FXML
    private AnchorPane anchorPane1 = new AnchorPane();

    @FXML
    private ImageView Weather = new ImageView();

    @FXML
    private ImageView AboutCity = new ImageView();


    @FXML
    void initialize() throws IOException {
        assert ButtonLondon != null : "fx:id=\"ButtonLondon\" was not injected: check your FXML file 'project plan.fxml'.";
        assert ButtonMadrid != null : "fx:id=\"ButtonMadrid\" was not injected: check your FXML file 'project plan.fxml'.";
        assert ButtonWashington != null : "fx:id=\"ButtonNewYork\" was not injected: check your FXML file 'project plan.fxml'.";
        assert ButtonYekaterinburg != null : "fx:id=\"ButtonYekaterinburg\" was not injected: check your FXML file 'project plan.fxml'.";
        assert City != null : "fx:id=\"City\" was not injected: check your FXML file 'project plan.fxml'.";
        assert FeelsLike != null : "fx:id=\"FeelsLike\" was not injected: check your FXML file 'project plan.fxml'.";
        assert Humidity != null : "fx:id=\"Humidity\" was not injected: check your FXML file 'project plan.fxml'.";
        assert MoscowButton != null : "fx:id=\"MoscowButton\" was not injected: check your FXML file 'project plan.fxml'.";
        assert SkorostVetra != null : "fx:id=\"SkorostVetra\" was not injected: check your FXML file 'project plan.fxml'.";
        assert Sunny != null : "fx:id=\"Sunny\" was not injected: check your FXML file 'project plan.fxml'.";
        assert Time != null : "fx:id=\"Time\" was not injected: check your FXML file 'project plan.fxml'.";


        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd HH:mm");
        String date = dateTimeFormatter.format(LocalDateTime.now());

            Time.setText("Weather at: " + date);
            AboutCity.setImage(imageEarth);

        Connection connectionMoscow = new Connection("moscow");
        Connection connectionLondon = new Connection("london");
        Connection connectionWashington = new Connection("washington");
        Connection connectionMadrid = new Connection("madrid");
        Connection connectionYekaterinburg = new Connection("yekaterinburg");
        Connection connectionParis = new Connection("paris");


        AtomicInteger index = new AtomicInteger(0);
        ButtonF.setOnAction(event -> {

            String ab = FeelsLike.getText();
            String ba = Degrees.getText();
            try {
                ba = ba = ba.substring(ba.indexOf(":")+1,ba.indexOf("°"));
                ab = ab.substring(ab.indexOf(":")+2,ab.indexOf("°"));
                if(index.get() == 0){
                    double a = Double.parseDouble(ab);
                    double b = Double.parseDouble(ba);
                    b= b*1.8;
                    b=b+32;
                    a= a*1.8;
                    a = a+32;
                    Degrees.setText(String.valueOf(Math.round(b)) +".0°F");
                    FeelsLike.setText("Feels like: " + String.valueOf(Math.round(a)) +".0°F");
                    index.getAndIncrement();
                    ButtonF.setText("°C");
                }
                else{
                    double a = Double.parseDouble(ab);
                    double b = Double.parseDouble(ba);
                    b = b -32;
                    b = b/1.8;
                    a = a-32;
                    a= a/1.8;
                    Degrees.setText(String.valueOf(Math.round(b) + ".0°C"));
                    FeelsLike.setText("Feels like: " + String.valueOf(Math.round(a)) +".0°C");
                    index.getAndDecrement();
                    ButtonF.setText("°F");
                }
            }
            catch (Exception e){
                City.setText("City: Choose the city please!");
            }
        });

        ParisButton.setOnAction(event -> {

            if(underline.equals("London")){
                ButtonLondon.setUnderline(false);
            }
            else if(underline.equals("Moscow")){
                MoscowButton.setUnderline(false);
            }
            else if(underline.equals("Madrid")){
                ButtonMadrid.setUnderline(false);
            }
            else if(underline.equals("Yekaterinburg")){
                ButtonYekaterinburg.setUnderline(false);
            }
            else if(underline.equals("Washington")){
                ButtonWashington.setUnderline(false);
            }
            underline = "Paris";
            ParisButton.setUnderline(true);

            changeIconWeather(connectionParis);
            AboutCity.setImage(imageParis);
            AboutCity.setVisible(true);

            Degrees.setText(connectionParis.getTemp_C_Api() + "°C");
            City.setText("City: " + connectionParis.getCityNameApi());
            FeelsLike.setText("Feels like: " + Double.parseDouble(connectionParis.getFeelsLikeC()) + "°C");
            Humidity.setProgress(Double.parseDouble(connectionParis.getHumidityApi())/100);
            Time.setText(connectionParis.getLocalTime());
            ProgressBar.setProgress(Double.parseDouble(connectionParis.getWindMph())/35);
            SpeedOfWind.setText(connectionParis.getWindMph() + " mph");

            index.set(0);
        });

        MoscowButton.setOnAction(event -> {
            if(underline.equals("London")){
                ButtonLondon.setUnderline(false);
            }
            else if(underline.equals("Paris")){
                ParisButton.setUnderline(false);
            }
            else if(underline.equals("Madrid")){
                ButtonMadrid.setUnderline(false);
            }
            else if(underline.equals("Yekaterinburg")){
                ButtonYekaterinburg.setUnderline(false);
            }
            else if(underline.equals("Washington")){
                ButtonWashington.setUnderline(false);
            }
            underline = "Moscow";
            MoscowButton.setUnderline(true);

            changeIconWeather(connectionMoscow);
            AboutCity.setImage(imageMoscow);
            AboutCity.setVisible(true);

            Degrees.setText(connectionMoscow.getTemp_C_Api() + "°C");
            City.setText("City: " + connectionMoscow.getCityNameApi());
            FeelsLike.setText("Feels like: " + Double.parseDouble(connectionMoscow.getFeelsLikeC()) + "°C");
            Humidity.setProgress(Double.parseDouble(connectionMoscow.getHumidityApi())/100);
            Time.setText(connectionMoscow.getLocalTime());
            ProgressBar.setProgress(Double.parseDouble(connectionMoscow.getWindMph())/35);
            SpeedOfWind.setText(connectionMoscow.getWindMph() + " mph");

            index.set(0);
        });


        ButtonLondon.setOnAction(event -> {
            if(underline.equals("Moscow")){
                MoscowButton.setUnderline(false);
            }
            else if(underline.equals("Paris")){
                ParisButton.setUnderline(false);
            }
            else if(underline.equals("Madrid")){
                ButtonMadrid.setUnderline(false);
            }
            else if(underline.equals("Yekaterinburg")){
                ButtonYekaterinburg.setUnderline(false);
            }
            else if(underline.equals("Washington")){
                ButtonWashington.setUnderline(false);
            }
                underline = "London";
            ButtonLondon.setUnderline(true);

            changeIconWeather(connectionLondon);
            AboutCity.setImage(imageLondon);
            AboutCity.setVisible(true);

            Degrees.setText(connectionLondon.getTemp_C_Api() + "°C");
            City.setText("City: " + connectionLondon.getCityNameApi());
            FeelsLike.setText("Feels like: " + Double.parseDouble(connectionLondon.getFeelsLikeC()) + "°C");
            Humidity.setProgress(Double.parseDouble(connectionLondon.getHumidityApi())/100);
            Time.setText(connectionLondon.getLocalTime());
            ProgressBar.setProgress(Double.parseDouble(connectionLondon.getWindMph())/35);
            SpeedOfWind.setText(connectionLondon.getWindMph() + " mph");

            index.set(0);
        });

        ButtonWashington.setOnAction(event -> {
            if(underline.equals("London")){
                ButtonLondon.setUnderline(false);
            }
            else if(underline.equals("Paris")){
                ParisButton.setUnderline(false);
            }
            else if(underline.equals("Madrid")){
                ButtonMadrid.setUnderline(false);
            }
            else if(underline.equals("Yekaterinburg")){
                ButtonYekaterinburg.setUnderline(false);
            }
            else if(underline.equals("Moscow")){
                MoscowButton.setUnderline(false);
            }
            underline = "Washington";
            ButtonWashington.setUnderline(true);

            changeIconWeather(connectionWashington);
            AboutCity.setImage(imageAmerica);
            AboutCity.setVisible(true);

            Degrees.setText(connectionWashington.getTemp_C_Api() + "°C");
            City.setText("City: " + connectionWashington.getCityNameApi());
            FeelsLike.setText("Feels like: " + Double.parseDouble(connectionWashington.getFeelsLikeC()) + "°C");
            Humidity.setProgress(Double.parseDouble(connectionWashington.getHumidityApi())/100);
            Time.setText(connectionWashington.getLocalTime());
            ProgressBar.setProgress(Double.parseDouble(connectionWashington.getWindMph())/35);
            SpeedOfWind.setText(connectionWashington.getWindMph() + " mph");

            index.set(0);
        });

        ButtonMadrid.setOnAction(event -> {
            if(underline.equals("London")){
                ButtonLondon.setUnderline(false);
            }
            else if(underline.equals("Paris")){
                ParisButton.setUnderline(false);
            }
            else if(underline.equals("Washington")){
                ButtonWashington.setUnderline(false);
            }
            else if(underline.equals("Yekaterinburg")){
                ButtonYekaterinburg.setUnderline(false);
            }
            else if(underline.equals("Moscow")){
                MoscowButton.setUnderline(false);
            }
            underline = "Madrid";
            ButtonMadrid.setUnderline(true);


            changeIconWeather(connectionMadrid);
            AboutCity.setImage(imageMadrid);
            AboutCity.setVisible(true);
            Degrees.setText(connectionMadrid.getTemp_C_Api() + "°C");
            City.setText("City: " + connectionMadrid.getCityNameApi());
            FeelsLike.setText("Feels like: " + Double.parseDouble(connectionMadrid.getFeelsLikeC()) + "°C");
            Humidity.setProgress(Double.parseDouble(connectionMadrid.getHumidityApi())/100);
            Time.setText(connectionMadrid.getLocalTime());
            ProgressBar.setProgress(Double.parseDouble(connectionMadrid.getWindMph())/35);
            SpeedOfWind.setText(connectionMadrid.getWindMph() + " mph");
            index.set(0);
        });

        ButtonYekaterinburg.setOnAction(event1 -> {
            if(underline.equals("London")){
                ButtonLondon.setUnderline(false);
            }
            else if(underline.equals("Paris")){
                ParisButton.setUnderline(false);
            }
            else if(underline.equals("Washington")){
                ButtonWashington.setUnderline(false);
            }
            else if(underline.equals("Madrid")){
                ButtonMadrid.setUnderline(false);
            }
            else if(underline.equals("Moscow")){
                MoscowButton.setUnderline(false);
            }
            underline = "Yekaterinburg";
            ButtonYekaterinburg.setUnderline(true);

            changeIconWeather(connectionYekaterinburg);
            AboutCity.setImage(imageEkb);
            AboutCity.setVisible(true);

            Degrees.setText(connectionYekaterinburg.getTemp_C_Api() + "°C");
            City.setText("City: " + connectionYekaterinburg.getCityNameApi());
            FeelsLike.setText("Feels like: " + Double.parseDouble(connectionYekaterinburg.getFeelsLikeC()) + "°C");
            Humidity.setProgress(Double.parseDouble(connectionYekaterinburg.getHumidityApi())/100);
            Time.setText(connectionYekaterinburg.getLocalTime());
            ProgressBar.setProgress(Double.parseDouble(connectionYekaterinburg.getWindMph())/35);
            SpeedOfWind.setText(connectionYekaterinburg.getWindMph() + " mph");

            index.set(0);
        });
    }

    private void changeIconWeather(Connection connection){
        if(connection.getText().toLowerCase().contains("snow")){
            Weather.setImage(imageSnow);
        }
        else if(connection.getText().toLowerCase().contains("rain")){
            Weather.setImage(imageRain);
        }
        else if(connection.getText().toLowerCase().contains("sunny")){
            Weather.setImage(imageSunny);
        }
        else if(connection.getText().toLowerCase().contains("cloudy")){
            Weather.setImage(imageCloudy);
        }
        else if(connection.getText().toLowerCase().contains("overcast")){
            Weather.setImage(imageOvercast);
        }
        else if(connection.getText().toLowerCase().contains("clear")){
            Weather.setImage(imageClear);
        }
        else {
            Weather.setImage(imageClear);
        }

    }



}

