import java.net.URISyntaxException;

/**
 * @author Craig Stroberg <strobergcd@gmail.com>
 */
public class AddressJsonUtil {

    public static void main(String[] args) throws URISyntaxException {
        String contents = FileUtil.readFile("addresses[4681].json");
        System.out.println(contents);
    }
}
