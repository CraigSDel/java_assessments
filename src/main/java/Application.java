import com.craigsdel.entity.Address;
import com.craigsdel.entity.Type;
import com.craigsdel.util.AddressUtil;
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
        final List<Address> addresses = AddressUtil.fileToJson("addresses[4681].json");
        System.out.println("Printing all the addresses\n");
        AddressUtil.prettyPrintAddress(addresses);
        System.out.println("\nPrinting with a filter\n");
        AddressUtil.prettyPrintAddress(addresses, new Type(2L, "Postal Address"));
    }
}
