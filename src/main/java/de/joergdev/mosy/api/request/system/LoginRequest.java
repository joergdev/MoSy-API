package de.joergdev.mosy.api.request.system;

public class LoginRequest
{
  private Integer secretHash;

  /**
   * <pre>
   * TenantId for multi-tanency mode.
   * 
   * If set tenantName is ignored.
   * </pre>
   */
  private Integer tenantId;

  /**
   * <pre>
   * TenantName for multi-tanency mode.
   * 
   * If tenantId is set, tenantName is ignored!
   * </pre>
   */
  private String tenantName;

  public Integer getSecretHash()
  {
    return secretHash;
  }

  public void setSecretHash(Integer secretHash)
  {
    this.secretHash = secretHash;
  }

  public Integer getTenantId()
  {
    return tenantId;
  }

  public void setTenantId(Integer tenantId)
  {
    this.tenantId = tenantId;
  }

  public String getTenantName()
  {
    return tenantName;
  }

  public void setTenantName(String tenantName)
  {
    this.tenantName = tenantName;
  }
}
