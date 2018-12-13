/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hmftool.producer;

import nl.hmf.core.GenericProducer;

/**
 *
 * @author Jan-Egbert
 */
public class ProducerWindowHelper {

    private ProducerWindow window;
    private GenericProducer producer;
    private String type;
    private String xmlSkeleton;

    public ProducerWindowHelper(ProducerWindow w, String type, String xmlSkeleton) {
        this.window = w;
        this.type = type;
        this.xmlSkeleton = xmlSkeleton;
        initialize();
    }

    public void produce(String xml) {
        String cid = producer.produceXML(xml);
    }

    private void initialize() {
        producer = new GenericProducer("HMFTool-" + type);
    }
}
