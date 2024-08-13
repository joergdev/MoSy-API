package de.joergdev.mosy.api.request.tenant;

import de.joergdev.mosy.api.model.Tenant;

public class SaveRequest
{
  private Tenant tenant;

  /**
   * <pre>
   * Must be set on creation.
   * Can be set on update (change).
   * </pre>
   */
  private Integer secretHash;

  public Tenant getTenant()
  {
    return tenant;
  }

  public void setTenant(Tenant tenant)
  {
    this.tenant = tenant;
  }

  public Integer getSecretHash()
  {
    return secretHash;
  }

  public void setSecretHash(Integer secretHash)
  {
    this.secretHash = secretHash;
  }

}
