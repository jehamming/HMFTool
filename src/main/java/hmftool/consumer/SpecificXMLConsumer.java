/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hmftool.consumer;

import nl.hmf.core.GenericXMLConsumer;
import nl.hmf.util.XMLUtil;

/**
 *
 * @author A121916
 */
public class SpecificXMLConsumer extends GenericXMLConsumer {

    private ConsumerWindowHelper helper;

    public SpecificXMLConsumer(ConsumerWindowHelper h) {
        this.helper = h;
    }

    @Override
    public void xmlRecieved(String xml) {
        String producer = XMLUtil.executeXPath(xml, "/nl.hmf.core.Message/header/producerId");
        helper.recieve(producer, xml);
    }
}
