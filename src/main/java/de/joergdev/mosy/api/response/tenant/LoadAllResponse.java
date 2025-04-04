package de.joergdev.mosy.api.response.tenant;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import de.joergdev.mosy.api.model.Tenant;
import de.joergdev.mosy.api.response.AbstractResponse;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoadAllResponse", propOrder = {"stateOK", "messages", "multiTanencyEnabled", "tenants"})
public class LoadAllResponse extends AbstractResponse
{
  @XmlElement(name = "multiTanencyEnabled")
  private boolean multiTanencyEnabled;

  @XmlElement(name = "tenants")
  private final List<Tenant> tenants = new ArrayList<>();

  public boolean isMultiTanencyEnabled()
  {
    return multiTanencyEnabled;
  }

  public void setMultiTanencyEnabled(boolean multiTanencyEnabled)
  {
    this.multiTanencyEnabled = multiTanencyEnabled;
  }

  public List<Tenant> getTenants()
  {
    return tenants;
  }
}
