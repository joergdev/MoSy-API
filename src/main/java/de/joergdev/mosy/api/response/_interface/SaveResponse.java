package de.joergdev.mosy.api.response._interface;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import de.joergdev.mosy.api.model.Interface;
import de.joergdev.mosy.api.response.AbstractResponse;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoadResponse", propOrder = {"stateOK", "messages", "_interface"})
public class SaveResponse extends AbstractResponse
{
  @XmlElement(name = "interface")
  private Interface _interface;

  public Interface getInterface()
  {
    return _interface;
  }

  public void setInterface(Interface _interface)
  {
    this._interface = _interface;
  }
}