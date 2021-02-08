package com.github.joergdev.mosy.api.response.record.session;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.github.joergdev.mosy.api.model.RecordSession;
import com.github.joergdev.mosy.api.response.AbstractResponse;

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