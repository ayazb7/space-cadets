import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class NameFromEmail {
  public static void main(String[] args) throws IOException {
    System.out.println("Enter email: ");
    Scanner input = new Scanner(System.in);

    String emailInput = input.next();

    String nameCode = emailInput.substring(0, emailInput.indexOf('@'));

    Document doc = Jsoup.connect("https://www.ecs.soton.ac.uk/people/"+nameCode).get();
    String title = doc.getElementsByTag("title").get(0).text();
    String name = title.substring(0, title.indexOf('|'));
    System.out.println(name);
  }
}