package com.github.joergdev.mosy.api.response.mockprofile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.github.joergdev.mosy.api.model.MockProfile;
import com.github.joergdev.mosy.api.response.AbstractResponse;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoadResponse", propOrder = {"stateOK", "messages", "mockProfile"})
public class LoadResponse extends AbstractResponse
{
  @XmlElement(name = "mockProfile")
  private MockProfile mockProfile;

  /**
   * @return the mockProfile
   */
  public MockProfile getMockProfile()
  {
    return mockProfile;
  }

  /**
   * @param mockProfile the mockProfile to set
   */
  public void setMockProfile(MockProfile mockProfile)
  {
    this.mockProfile = mockProfile;
  }
}