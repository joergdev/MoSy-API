package de.joergdev.mosy.api.response;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EmptyResponse", propOrder = {"stateOK", "messages"})
public class EmptyResponse extends AbstractResponse
{

}
