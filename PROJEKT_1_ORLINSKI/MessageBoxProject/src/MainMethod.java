import MessageBox.MessageBoxButtons;
import MessageBox.MessageBoxFx;
import MessageBox.MessageBoxIcons;
import MessageBox.MessageBoxResult;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * 
 * @author Dominik
 * @version 2.0
 * 
 * Przyk≥ad uøycia przeciπøonej metody 'show' zamimplementowanej w klasie MessageBoxFx.
 * Klasa z niej korzystajπca (MainMethod) zostaje rozszerzona o 'Application'.
 * W tej klasie zostaje wywo≥ana metoda 'launch' z przeciπøonπ metodπ 'start'.
 * 
 */

public class MainMethod extends Application {

	public static void main(String[] args) {
		launch();
	}
		
	@Override
	public void start(Stage primaryStage){
		MessageBoxResult result = MessageBoxFx.show(
				"Lorsque j'avais six ans j'ai vu, une fois, une magnifique image, dans un livre sur la Foret Vierge qui s'appelait 'Histoires Vecues'. Ca representait un serpent boa qui avalait un fauve. Voila la copie du dessin.",
				"Okieneczko", MessageBoxButtons.AbortRetryIgnore, MessageBoxIcons.Warning);
		System.out.println("Odpowiedü : " + result + "\n");
		result = MessageBoxFx.show(
				"Sabine ist jetzt zwanzig. Bis zum letzten Jahr war sie mit Heinz befreundet. Sie haben in derselben Stadt gewohnt und sind in dieselbe Schule gegangen. ",
				"Drugie okienko", MessageBoxButtons.OK, MessageBoxIcons.Information);
		System.out.println("Odpowiedü : " + result + "\n");
	}
}