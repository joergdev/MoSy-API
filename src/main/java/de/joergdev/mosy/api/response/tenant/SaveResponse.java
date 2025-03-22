package de.joergdev.mosy.api.response.tenant;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import de.joergdev.mosy.api.model.Tenant;
import de.joergdev.mosy.api.response.AbstractResponse;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SaveResponse", propOrder = {"stateOK", "messages", "tenant"})
public class SaveResponse extends AbstractResponse
{
  @XmlElement(name = "tenant")
  private Tenant tenant;

  public Tenant getTenant()
  {
    return tenant;
  }

  public void setTenant(Tenant tenant)
  {
    this.tenant = tenant;
  }

}
