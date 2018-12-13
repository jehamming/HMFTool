/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hmftool.consumer;

import java.util.Calendar;
import java.util.Date;
import nl.hmf.util.Log;
import nl.hmf.util.XMLUtil;

/**
 *
 * @author Jan-Egbert
 */
public class ConsumerWindowHelper {

    private ConsumerWindow window;
    private String type;
    private SpecificXMLConsumer consumer;

    public ConsumerWindowHelper( ConsumerWindow w , String type) {
        this.window = w;
        this.type = type;
        initialize();
    }

    private long computeDelay(String xml) {
        long retVal = 0;
        String xpath = "/nl.hmf.core.Message/header/timestamp";
        String s = XMLUtil.executeXPath(xml, xpath);
        long timeOfMessage = Long.valueOf(s);
        long currentTime = Calendar.getInstance().getTimeInMillis();
        retVal = currentTime - timeOfMessage;
        return retVal;
    }

    private void initialize() {
        consumer = new SpecificXMLConsumer(this);
        // Make this consumer specific
        String xpath = "/nl.hmf.core.Message/content[@class='" + type + "']";
        consumer.addXPathQuery(xpath);
        consumer.startConsuming();
    }

    public void recieve( String producer, String xml ) {
        long delay = computeDelay(xml);
        ConsumedItem item = new ConsumedItem();
        item.setProducer(producer);
        item.setTime( new Date() );
        item.setXml(xml);
        item.setDelay( delay );
        window.addConsumedItem( item );
    }


    

}
