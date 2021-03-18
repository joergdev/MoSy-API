package de.joergdev.mosy.api.response.record.session;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import de.joergdev.mosy.api.model.RecordSession;
import de.joergdev.mosy.api.response.AbstractResponse;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateResponse", propOrder = {"stateOK", "messages", "recordSession"})
public class CreateResponse extends AbstractResponse
{
  private RecordSession recordSession;

  public RecordSession getRecordSession()
  {
    return recordSession;
  }

  public void setRecordSession(RecordSession recordSession)
  {
    this.recordSession = recordSession;
  }
}