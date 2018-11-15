import net.openhft.chronicle.bytes.MethodReader;
import net.openhft.chronicle.queue.impl.single.SingleChronicleQueueBuilder;

/**
 * Copyright (C) 2006-2017  AdMaster Co.Ltd.
 * All right reserved.
 *
 * @author: whitelilis@gmail.com on 18/11/15
 */
public class Reader implements BlobInterface {
    public static void main(String[] args) {
        String path = "fakeQueue";
        Reader r1 = new Reader();
        MethodReader driver = SingleChronicleQueueBuilder.binary(path).build().createTailer().toEnd().methodReader(r1);
        while(true) {
            driver.readOne();
        }
    }

    @Override
    public void onBlob(Blob blob) {
        System.out.println("here i got " + blob.value);
    }
}
