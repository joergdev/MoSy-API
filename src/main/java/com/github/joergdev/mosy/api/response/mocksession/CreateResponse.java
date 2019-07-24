package com.github.joergdev.mosy.api.response.mocksession;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.github.joergdev.mosy.api.model.MockSession;
import com.github.joergdev.mosy.api.response.AbstractResponse;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateResponse", propOrder = {"stateOK", "messages", "mockSession"})
public class CreateResponse extends AbstractResponse
{
  private MockSession mockSession;

  public MockSession getMockSession()
  {
    return mockSession;
  }

  public void setMockSession(MockSession mockSession)
  {
    this.mockSession = mockSession;
  }
}