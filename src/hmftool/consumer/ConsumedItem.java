/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hmftool.consumer;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Jan-Egbert
 */
public class ConsumedItem {

    private String xml;
    private Date time;
    private String producer;
    private long delay;
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss:SS");
    public long getDelay() {
        return delay;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    @Override
    public String toString() {
        return formatter.format(getTime());
    }
}
