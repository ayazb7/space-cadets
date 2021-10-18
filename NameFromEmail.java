import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class NameFromEmail {
  public static void main(String[] args) throws IOException {
    System.out.println("Enter email: ");
    Scanner input = new Scanner(System.in);

    String emailInput = input.next(); //User inputs an email address

    String nameCode = emailInput.substring(0, emailInput.indexOf('@')); //Substrings the email address to just the name code

    Document doc = Jsoup.connect("https://www.ecs.soton.ac.uk/people/"+nameCode).get(); //Jsoup used to get the html file of the ecs soton link
    String title = doc.getElementsByTag("title").get(0).text(); //Obtains the string held in the title element
    String name = title.substring(0, title.indexOf('|')); //Substrings the title to get the full name only
    System.out.println(name);
  }
}