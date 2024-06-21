package de.joergdev.mosy.api.model;

import java.time.LocalDateTime;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import de.joergdev.mosy.api.APIConstants;
import de.joergdev.mosy.api.model.core.AbstractModel;
import de.joergdev.mosy.shared.Utils;

public class RecordSession extends AbstractModel implements Cloneable
{
  private Integer recordSessionID;

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

  @Override
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
    return recordSessionID == null ? super.hashCode() : recordSessionID;
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
               && Utils.isEqual(Utils.localDateTimeToString(getCreatedAsLdt()), Utils.localDateTimeToString(other.getCreatedAsLdt())));
  }
}