package com.github.joergdev.mosy.api.model;

import java.time.LocalDateTime;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.joergdev.mosy.api.model.core.AbstractModel;
import com.github.joergdev.mosy.shared.Utils;

public class MockSession extends AbstractModel implements Cloneable
{
  private Integer mockSessionID;
  private Date created;

  public Integer getMockSessionID()
  {
    return mockSessionID;
  }

  public void setMockSessionID(Integer mockSessionID)
  {
    this.mockSessionID = mockSessionID;
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

  public MockSession clone()
  {
    try
    {
      MockSession clone = (MockSession) super.clone();

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
    StringBuilder bui = new StringBuilder(22);

    bui.append(mockSessionID);

    if (created != null)
    {
      bui.append(" - ").append(Utils.localDateTimeToString(getCreatedAsLdt()));
    }

    return bui.toString();
  }

  @Override
  public int hashCode()
  {
    return mockSessionID == null
        ? super.hashCode()
        : mockSessionID;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj instanceof MockSession == false)
    {
      return false;
    }

    if (this == obj)
    {
      return true;
    }

    MockSession other = (MockSession) obj;

    return Utils.isEqual(mockSessionID, other.mockSessionID)
           && (created != null && other.created != null
               && Utils.isEqual(Utils.localDateTimeToString(getCreatedAsLdt()),
                   Utils.localDateTimeToString(other.getCreatedAsLdt())));
  }
}