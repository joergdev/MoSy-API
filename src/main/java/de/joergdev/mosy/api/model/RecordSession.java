package de.joergdev.mosy.api.model;

import java.time.LocalDateTime;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import de.joergdev.mosy.api.model.core.AbstractModel;
import de.joergdev.mosy.shared.Utils;

public class RecordSession extends AbstractModel implements Cloneable
{
  private Integer recordSessionID;
  private Date created;

  public RecordSession()
  {

  }

  public RecordSession(Integer recordSessionID)
  {
    this.recordSessionID = recordSessionID;
  }

  public Integer getRecordSessionID()
  {
    return recordSessionID;
  }

  public void setRecordSessionID(Integer recordSessionID)
  {
    this.recordSessionID = recordSessionID;
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

  public RecordSession clone()
  {
    try
    {
      RecordSession clone = (RecordSession) super.clone();

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

    bui.append(recordSessionID);

    if (created != null)
    {
      bui.append(" - ").append(Utils.localDateTimeToString(getCreatedAsLdt()));
    }

    return bui.toString();
  }

  @Override
  public int hashCode()
  {
    return recordSessionID == null
        ? super.hashCode()
        : recordSessionID;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj instanceof RecordSession == false)
    {
      return false;
    }

    if (this == obj)
    {
      return true;
    }

    RecordSession other = (RecordSession) obj;

    return Utils.isEqual(recordSessionID, other.recordSessionID)
           && (created != null && other.created != null
               && Utils.isEqual(Utils.localDateTimeToString(getCreatedAsLdt()),
                   Utils.localDateTimeToString(other.getCreatedAsLdt())));
  }
}