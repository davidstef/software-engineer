import good.AnotherGoodClient;
import good.GoodClient;
import good.GoodServer;

public class OMain {

        public static void main(String[] args) {
            testGoodO();
        }

        private static void testGoodO() {
            GoodClient client = new GoodClient();
            GoodServer server = new GoodServer();
            server.reactToClient(client);

            AnotherGoodClient anotherBadClient = new AnotherGoodClient();
            server.reactToClient(anotherBadClient);



    }
}
