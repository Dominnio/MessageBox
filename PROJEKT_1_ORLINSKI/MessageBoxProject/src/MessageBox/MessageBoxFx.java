package MessageBox;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 
 * @author Dominik
 * 
 */

/**'
 * 
 * Klasa MessageBoxFx nie wymaga konstruktora, poniewa� nie tworz� �adnego obiektu tej klasy.
 * Wywo�uj� z niej jedynie funkcj� statyczn� 'show'. 
 * Klasa ta przechowuje prywatne zmienne decyduj�ce o rodzaju wy�wietlanego okna dialogowego.
 */

public class MessageBoxFx {
	private static String boxTitle;
	private static String boxStatement;
	private static MessageBoxIcons boxIcon;
	private static MessageBoxButtons boxButtons;
	private static MessageBoxResult boxResult;
	
	/**
	 * Metoda statyczna 'show' odpowiedzialna jest za wy�wietlenie okienka z parametrami przekazanymi jej jako agrumenty.
	 * Ustawia ona prywatne zmienne klasy MessageBoxFx, a w razie potrzeby ucina zbyt d�ugie napisy.
	 * Metoda 'show' wywo�uje metod� 'showWindow'.
	 * Warto��, kt�r� zwraca metoda 'showWindow' jest zapisywana jako zmienna klasy MessegeBoxFx.
	 * @param statement - tekst wy�wietlany w oknie dialogowym
	 * @param title - tytu� okna dialogowego
	 * @param buttonsGroup - przyciski okna dialogowego
	 * @param icon - ikona okna dialogowego
	 */
	
	public static MessageBoxResult show(String statement, String title, MessageBoxButtons buttonsGroup,
			MessageBoxIcons icon) {
		if (statement.length() > 300) {
			statement = statement.substring(0, 300);
		}
		boxStatement = statement;
		if (title.length() > 50) {
			title = title.substring(0, 50);
		}
		boxTitle = title;
		boxIcon = icon;
		boxButtons = buttonsGroup;
		showWindow();
		if(boxResult == null) {
			boxResult = MessageBoxResult.Exit;
		}
		return boxResult;
	}
	
	/**
	 * Okno dialogowe jest zbudowane z jednego obiektu typu Vbox, kt�ry mie�ci dwa obiekty typu HBox - hboxup i hboxdown.
	 * W hboxup znajduje si� ikona oraz tekst, w hboxdown wszystkie przyciski.
	 * Przyciski maj� zdefiniowan� akcj� wkonywan� w przypadku klikni�cia - jest to zwr�cenie warto�ci przysisku przez metod� 'showWindow'.
	 * Je�li u�ytkownik zamknie okno dialogowe czerwonym przyciskiem zamkni�cia, to zostanie zwr�cona warto�� null.
	 * Zablokowana zosta�a mo�liwo�� zmiany rozmiaru okna dialogowego.  
	 */

	private static void showWindow() {
		Stage primaryStage = new Stage();	
		VBox vbox = new VBox(50);
		vbox.setPadding(new Insets(30));

		HBox hboxup = new HBox(50);
		hboxup.setAlignment(Pos.CENTER);

		HBox hboxdown = new HBox(50);
		hboxdown.setAlignment(Pos.CENTER);

		Text text = new Text(10, 50, boxStatement);
		text.setWrappingWidth(300);
		text.setFont(new Font(12));

		Image image = new Image(boxIcon.toString());
		ImageView view = new ImageView();
		view.setImage(image);

		hboxup.getChildren().addAll(view, text);

		for (int i = 0; i < boxButtons.getCount(); i++) {
			Button button = new Button(boxButtons.getText(i));
			String buttonText = boxButtons.getText(i);
			button.setOnAction((event) -> {
				boxResult = MessageBoxResult.getResult(buttonText);
				primaryStage.close();
			});
			hboxdown.getChildren().add(button);
		}

		vbox.getChildren().addAll(hboxup, hboxdown);

		Scene scene = new Scene(vbox, 500, 200);
		primaryStage.setResizable(false);
		primaryStage.setTitle(boxTitle);
		primaryStage.setScene(scene);
		primaryStage.showAndWait();
	}
}