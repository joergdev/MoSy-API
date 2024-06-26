package de.joergdev.mosy.api.model;

import java.time.LocalDateTime;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import de.joergdev.mosy.api.APIConstants;
import de.joergdev.mosy.api.model.core.AbstractModel;
import de.joergdev.mosy.shared.Utils;

public class MockProfile extends AbstractModel implements Cloneable
{
  private Integer mockProfileID;

  /**
   * Date of creation.
   * 
   * Cause of problems with json parsing as LocalDateTime "created" is instanceof Date.
   * For handling as LocalDateTime though there exists a separate getter/setter.
   * 
   * Format must be set cause of problems running in JBoss EAP 7.4.
   * (Cannot deserialize value of type `java.util.Date` from String "2024-04-30T05:11:18.304Z[UTC]": not a valid representation)
   */
  @JsonFormat(pattern = APIConstants.DATE_TIME_PATTNER)
  private Date created;

  private String name;
  private boolean persistent;
  private boolean useCommonMocks;
  private String description;

  /**
   * @return the mockProfileID
   */
  public Integer getMockProfileID()
  {
    return mockProfileID;
  }

  /**
   * @param mockProfileID the mockProfileID to set
   */
  public void setMockProfileID(Integer mockProfileID)
  {
    this.mockProfileID = mockProfileID;
  }

  /**
   * @return the name
   */
  public String getName()
  {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name)
  {
    this.name = name;
  }

  /**
   * @return the persistent
   */
  public boolean isPersistent()
  {
    return persistent;
  }

  /**
   * @param persistent the persistent to set
   */
  public void setPersistent(boolean persistent)
  {
    this.persistent = persistent;
  }

  /**
   * @return the useCommonMocks
   */
  public boolean isUseCommonMocks()
  {
    return useCommonMocks;
  }

  /**
   * @param useCommonMocks the useCommonMocks to set
   */
  public void setUseCommonMocks(boolean useCommonMocks)
  {
    this.useCommonMocks = useCommonMocks;
  }

  /**
   * @return the description
   */
  public String getDescription()
  {
    return description;
  }

  /**
   * @param description the description to set
   */
  public void setDescription(String description)
  {
    this.description = description;
  }

  public Date getCreated()
  {
    return created;
  }

  public void setCreated(Date created)
  {
    this.created = created;
  }

  @JsonIgnore
  public String getCreatedAsString()
  {
    return Utils.localDateTimeToString(getCreatedAsLdt());
  }

  @JsonIgnore
  public LocalDateTime getCreatedAsLdt()
  {
    return Utils.dateToLocalDateTime(created);
  }

  public void setCreatedAsLdt(LocalDateTime created)
  {
    this.created = Utils.localDateTimeToDate(created);
  }

  @Override
  public MockProfile clone()
  {
    try
    {
      MockProfile clone = (MockProfile) super.clone();

      return clone;
    }
    catch (CloneNotSupportedException ex)
    {
      throw new IllegalStateException(ex);
    }
  }

  @Override
  public String toString()
  {
    StringBuilder bui = new StringBuilder();

    bui.append(mockProfileID).append(" - ").append(name);

    bui.append(" - ").append("persistent: ").append(persistent);

    bui.append(" - ").append("use common mocks: ").append(useCommonMocks);

    return bui.toString();
  }

  @Override
  public int hashCode()
  {
    return mockProfileID == null ? super.hashCode() : mockProfileID;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj instanceof MockProfile == false)
    {
      return false;
    }

    if (this == obj)
    {
      return true;
    }

    MockProfile other = (MockProfile) obj;

    return Utils.isEqual(mockProfileID, other.mockProfileID) && Utils.isEqual(name, other.name)
           && (created == null || other.created == null
               || Utils.isEqual(Utils.localDateTimeToString(getCreatedAsLdt()), Utils.localDateTimeToString(other.getCreatedAsLdt())));
  }
}
