package de.joergdev.mosy.api.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EmptyResponse", propOrder = {"stateOK", "messages"})
public class EmptyResponse extends AbstractResponse
{

}
