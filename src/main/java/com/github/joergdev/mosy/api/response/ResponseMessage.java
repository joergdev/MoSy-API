package com.github.joergdev.mosy.api.response;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseMessage", propOrder = {"level", "code", "message", "additionalInfos"})
public class ResponseMessage
{
  @XmlElement(name = "level")
  private ResponseMessageLevel level;

  @XmlElement(name = "code")
  private Integer code;

  @XmlElement(name = "message")
  private String message;

  @XmlElement(name = "additionalInfos")
  private List<String> additionalInfos = new ArrayList<>();

  public ResponseMessageLevel getLevel()
  {
    return level;
  }

  public void setLevel(ResponseMessageLevel level)
  {
    this.level = level;
  }

  public Integer getCode()
  {
    return code;
  }

  public void setCode(Integer code)
  {
    this.code = code;
  }

  public String getMessage()
  {
    return message;
  }

  public void setMessage(String message)
  {
    this.message = message;
  }

  public List<String> getAdditionalInfos()
  {
    return additionalInfos;
  }

  public void setAdditionalInfos(List<String> additionalInfos)
  {
    this.additionalInfos = additionalInfos;
  }

  public ResponseMessage withAddtitionalInfo(String additionalInfo)
  {
    ResponseMessage cln = clone();

    if (additionalInfo != null)
    {
      cln.additionalInfos.add(additionalInfo);
    }

    return cln;
  }

  public ResponseMessage clone()
  {
    ResponseMessage cln = new ResponseMessage();
    cln.code = code;
    cln.level = level;
    cln.message = message;
    cln.additionalInfos.addAll(additionalInfos);

    return cln;
  }

  public String getFullMessage()
  {
    StringBuilder bui = new StringBuilder();

    if (message != null)
    {
      bui.append(message);
    }

    if (!additionalInfos.isEmpty())
    {
      bui.append(" [");

      Iterator<String> it = additionalInfos.iterator();
      while (it.hasNext())
      {
        bui.append(it.next());

        if (it.hasNext())
        {
          bui.append(", ");
        }
      }

      bui.append("]");
    }

    return bui.toString();
  }

  @Override
  public String toString()
  {
    StringBuilder bui = new StringBuilder();

    if (level != null)
    {
      bui.append("[").append(level).append("]");
    }

    if (code != null)
    {
      if (bui.length() > 0)
      {
        bui.append(" - ");
      }

      bui.append(code);
    }

    String fullMsg = getFullMessage();
    if (fullMsg != null && !fullMsg.trim().isEmpty())
    {
      if (bui.length() > 0)
      {
        bui.append(" - ");
      }

      bui.append(fullMsg);
    }

    return bui.toString();
  }
}