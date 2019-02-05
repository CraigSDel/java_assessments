import com.craigsdel.entity.Address;
import com.craigsdel.entity.Type;
import com.craigsdel.util.AddressJsonUtil;
import com.craigsdel.util.FileUtil;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * @author Craig Stroberg <strobergcd@gmail.com>
 */
public class Application {

    public static void main(String[] args) throws URISyntaxException, IOException {
        final String fileContent = FileUtil.readFile("addresses[4681].json");
        final List<Address> addresses = AddressJsonUtil.fileToJson("addresses[4681].json");
        System.out.println("Printing all the addresses\n");
        AddressJsonUtil.prettyPrintAddress(addresses);
        System.out.println("\nPrinting with a filter\n");
        AddressJsonUtil.prettyPrintAddress(addresses, new Type(2L, "Postal Address"));
    }
}
