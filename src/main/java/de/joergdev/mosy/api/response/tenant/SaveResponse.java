package de.joergdev.mosy.api.response.tenant;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
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
