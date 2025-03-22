package de.joergdev.mosy.api.response.record.session;

import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import de.joergdev.mosy.api.model.RecordSession;
import de.joergdev.mosy.api.response.AbstractResponse;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoadSessionsResponse", propOrder = {"stateOK", "messages", "recordSessions"})
public class LoadSessionsResponse extends AbstractResponse
{
  @XmlElement(name = "recordSessions")
  private List<RecordSession> recordSessions;

  public List<RecordSession> getRecordSessions()
  {
    return recordSessions;
  }

  public void setRecordSessions(List<RecordSession> recordSessions)
  {
    this.recordSessions = recordSessions;
  }
}