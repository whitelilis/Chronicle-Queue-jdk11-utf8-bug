import net.openhft.chronicle.queue.impl.single.SingleChronicleQueueBuilder;

/**
 * Copyright (C) 2006-2017  AdMaster Co.Ltd.
 * All right reserved.
 *
 * @author: whitelilis@gmail.com on 18/11/15
 */
public class Writer {
    public static void main(String[] args) {
        String path = "fakeQueue";
        BlobInterface writer = SingleChronicleQueueBuilder.binary(path).build().acquireAppender().methodWriter(BlobInterface.class);
        Blob blob = new Blob();
        blob.value = 15;
        blob.mm = "你好";
        writer.onBlob(blob);
    }
}
