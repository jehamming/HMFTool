/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hmftool;

import nl.hmf.core.GenericXMLConsumer;
import nl.hmf.util.XMLUtil;

/**
 *
 * @author A121916
 */
public class BasicXMLConsumer extends GenericXMLConsumer {

    private Tool tool;

    public BasicXMLConsumer(Tool t) {
        this.tool = t;
    }

    @Override
    public void xmlRecieved(String xml) {
        String name = XMLUtil.executeXPath(xml, "/nl.hmf.core.Message/content/@class");
        ReceivedMessage m = new ReceivedMessage();
        m.setName(name);
        m.setXml(xml);
        tool.messageReceived(m);
    }
}
