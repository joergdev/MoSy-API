package de.joergdev.mosy.api.model;

import de.joergdev.mosy.api.model.core.AbstractModel;
import de.joergdev.mosy.shared.Utils;

public class Tenant extends AbstractModel implements Cloneable
{
  private Integer tenantId;
  private String name;

  public Integer getTenantId()
  {
    return tenantId;
  }

  public void setTenantId(Integer tenantId)
  {
    this.tenantId = tenantId;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  @Override
  public Tenant clone()
  {
    try
    {
      Tenant clone = (Tenant) super.clone();

      return clone;
    }
    catch (CloneNotSupportedException ex)
    {
      throw new IllegalStateException(ex);
    }
  }

  @Override
  public int hashCode()
  {
    if (tenantId != null)
    {
      return tenantId;
    }
    else if (!Utils.isEmpty(name))
    {
      return name.hashCode();
    }
    else
    {
      return super.hashCode();
    }
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj instanceof Tenant == false)
    {
      return false;
    }

    if (this == obj)
    {
      return true;
    }

    Tenant other = (Tenant) obj;

    if (tenantId != null && other.tenantId != null)
    {
      return tenantId.equals(other.tenantId);
    }

    return Utils.isEqual(name, other.name);
  }

  @Override
  public String toString()
  {
    return name == null ? super.toString() : name;
  }
}
