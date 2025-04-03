package de.joergdev.mosy.api.response.mockprofile;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import de.joergdev.mosy.api.model.MockProfile;
import de.joergdev.mosy.api.response.AbstractResponse;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SaveResponse", propOrder = {"stateOK", "messages", "mockProfile"})
public class SaveResponse extends AbstractResponse
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