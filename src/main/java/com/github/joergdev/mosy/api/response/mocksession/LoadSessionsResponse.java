package com.github.joergdev.mosy.api.response.mocksession;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.github.joergdev.mosy.api.model.MockSession;
import com.github.joergdev.mosy.api.response.AbstractResponse;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoadSessionsResponse", propOrder = {"stateOK", "messages", "baseData", "mockSessions"})
public class LoadSessionsResponse extends AbstractResponse
{
  @XmlElement(name = "mockSessions")
  private List<MockSession> mockSessions;

  public List<MockSession> getMockSessions()
  {
    return mockSessions;
  }

  public void setMockSessions(List<MockSession> mockSessions)
  {
    this.mockSessions = mockSessions;
  }
}