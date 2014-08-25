/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package dog_breed_info.thrift;

import org.apache.commons.lang.builder.HashCodeBuilder;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.thrift.*;
import org.apache.thrift.async.*;
import org.apache.thrift.meta_data.*;
import org.apache.thrift.transport.*;
import org.apache.thrift.protocol.*;

import com.twitter.util.Future;
import com.twitter.util.Function;
import com.twitter.util.Function2;
import com.twitter.util.Try;
import com.twitter.util.Return;
import com.twitter.util.Throw;
import com.twitter.finagle.thrift.ThriftClientRequest;

public class DogBreedInfo {
  public interface Iface {
    public BeautifulBreedResponse isBeautiful(BeautifulBreedRequest request) throws TException;
  }

  public interface AsyncIface {
    public void isBeautiful(BeautifulBreedRequest request, AsyncMethodCallback<AsyncClient.isBeautiful_call> resultHandler) throws TException;
  }

  public interface ServiceIface {
    public Future<BeautifulBreedResponse> isBeautiful(BeautifulBreedRequest request);
  }

  public static class Client implements TServiceClient, Iface {
    public static class Factory implements TServiceClientFactory<Client> {
      public Factory() {}
      public Client getClient(TProtocol prot) {
        return new Client(prot);
      }
      public Client getClient(TProtocol iprot, TProtocol oprot) {
        return new Client(iprot, oprot);
      }
    }

    public Client(TProtocol prot)
    {
      this(prot, prot);
    }

    public Client(TProtocol iprot, TProtocol oprot)
    {
      iprot_ = iprot;
      oprot_ = oprot;
    }

    protected TProtocol iprot_;
    protected TProtocol oprot_;

    protected int seqid_;

    public TProtocol getInputProtocol()
    {
      return this.iprot_;
    }

    public TProtocol getOutputProtocol()
    {
      return this.oprot_;
    }

    public BeautifulBreedResponse isBeautiful(BeautifulBreedRequest request) throws TException
    {
      send_isBeautiful(request);
      return recv_isBeautiful();
    }

    public void send_isBeautiful(BeautifulBreedRequest request) throws TException
    {
      oprot_.writeMessageBegin(new TMessage("isBeautiful", TMessageType.CALL, ++seqid_));
      isBeautiful_args args = new isBeautiful_args();
      args.setRequest(request);
      args.write(oprot_);
      oprot_.writeMessageEnd();
      oprot_.getTransport().flush();
    }

    public BeautifulBreedResponse recv_isBeautiful() throws TException
    {
      TMessage msg = iprot_.readMessageBegin();
      if (msg.type == TMessageType.EXCEPTION) {
        TApplicationException x = TApplicationException.read(iprot_);
        iprot_.readMessageEnd();
        throw x;
      }
      if (msg.seqid != seqid_) {
        throw new TApplicationException(TApplicationException.BAD_SEQUENCE_ID, "isBeautiful failed: out of sequence response");
      }
      isBeautiful_result result = new isBeautiful_result();
      result.read(iprot_);
      iprot_.readMessageEnd();
      if (result.isSetSuccess()) {
        return result.success;
      }
      throw new TApplicationException(TApplicationException.MISSING_RESULT, "isBeautiful failed: unknown result");
    }
  }

  public static class AsyncClient extends TAsyncClient implements AsyncIface {
    public static class Factory implements TAsyncClientFactory<AsyncClient> {
      private TAsyncClientManager clientManager;
      private TProtocolFactory protocolFactory;
      public Factory(TAsyncClientManager clientManager, TProtocolFactory protocolFactory) {
        this.clientManager = clientManager;
        this.protocolFactory = protocolFactory;
      }
      public AsyncClient getAsyncClient(TNonblockingTransport transport) {
        return new AsyncClient(protocolFactory, clientManager, transport);
      }
    }

    public AsyncClient(TProtocolFactory protocolFactory, TAsyncClientManager clientManager, TNonblockingTransport transport) {
      super(protocolFactory, clientManager, transport);
    }

    public void isBeautiful(BeautifulBreedRequest request, AsyncMethodCallback<isBeautiful_call> resultHandler) throws TException {
      checkReady();
      isBeautiful_call method_call = new isBeautiful_call(request, resultHandler, this, protocolFactory, transport);
      manager.call(method_call);
    }

    public static class isBeautiful_call extends TAsyncMethodCall {
      private BeautifulBreedRequest request;

      public isBeautiful_call(BeautifulBreedRequest request, AsyncMethodCallback<isBeautiful_call> resultHandler, TAsyncClient client, TProtocolFactory protocolFactory, TNonblockingTransport transport) throws TException {
        super(client, protocolFactory, transport, resultHandler, false);
        this.request = request;
      }

      public void write_args(TProtocol prot) throws TException {
        prot.writeMessageBegin(new TMessage("isBeautiful", TMessageType.CALL, 0));
        isBeautiful_args args = new isBeautiful_args();
        args.setRequest(request);
        args.write(prot);
        prot.writeMessageEnd();
      }

      public BeautifulBreedResponse getResult() throws TException {
        if (getState() != State.RESPONSE_READ) {
          throw new IllegalStateException("Method call not finished!");
        }
        TMemoryInputTransport memoryTransport = new TMemoryInputTransport(getFrameBuffer().array());
        TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
        return (new Client(prot)).recv_isBeautiful();
      }
     }
   }


  public static class ServiceToClient implements ServiceIface {
    private com.twitter.finagle.Service<ThriftClientRequest, byte[]> service;
    private TProtocolFactory protocolFactory;
    public ServiceToClient(com.twitter.finagle.Service<ThriftClientRequest, byte[]> service, TProtocolFactory protocolFactory) {
      
      this.service = service;
      this.protocolFactory = protocolFactory;
    }

    public Future<BeautifulBreedResponse> isBeautiful(BeautifulBreedRequest request) {
      try {
        // TODO: size
        TMemoryBuffer __memoryTransport__ = new TMemoryBuffer(512);
        TProtocol __prot__ = this.protocolFactory.getProtocol(__memoryTransport__);
        __prot__.writeMessageBegin(new TMessage("isBeautiful", TMessageType.CALL, 0));
        isBeautiful_args __args__ = new isBeautiful_args();
        __args__.setRequest(request);
        __args__.write(__prot__);
        __prot__.writeMessageEnd();


        byte[] __buffer__ = Arrays.copyOfRange(__memoryTransport__.getArray(), 0, __memoryTransport__.length());
        ThriftClientRequest __request__ = new ThriftClientRequest(__buffer__, false);
        Future<byte[]> __done__ = this.service.apply(__request__);
        return __done__.flatMap(new Function<byte[], Future<BeautifulBreedResponse>>() {
          public Future<BeautifulBreedResponse> apply(byte[] __buffer__) {
            TMemoryInputTransport __memoryTransport__ = new TMemoryInputTransport(__buffer__);
            TProtocol __prot__ = ServiceToClient.this.protocolFactory.getProtocol(__memoryTransport__);
            try {
              return Future.value((new Client(__prot__)).recv_isBeautiful());
            } catch (Exception e) {
              return Future.exception(e);
            }
          }
        });
      } catch (TException e) {
        return Future.exception(e);
      }
    }
  }

  public static class Processor implements TProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(Processor.class.getName());
    public Processor(Iface iface)
    {
      iface_ = iface;
      processMap_.put("isBeautiful", new isBeautiful());
    }

    protected static interface ProcessFunction {
      public void process(int seqid, TProtocol iprot, TProtocol oprot) throws TException;
    }

    private Iface iface_;
    protected final HashMap<String,ProcessFunction> processMap_ = new HashMap<String,ProcessFunction>();

    public boolean process(TProtocol iprot, TProtocol oprot) throws TException
    {
      TMessage msg = iprot.readMessageBegin();
      ProcessFunction fn = processMap_.get(msg.name);
      if (fn == null) {
        TProtocolUtil.skip(iprot, TType.STRUCT);
        iprot.readMessageEnd();
        TApplicationException x = new TApplicationException(TApplicationException.UNKNOWN_METHOD, "Invalid method name: '"+msg.name+"'");
        oprot.writeMessageBegin(new TMessage(msg.name, TMessageType.EXCEPTION, msg.seqid));
        x.write(oprot);
        oprot.writeMessageEnd();
        oprot.getTransport().flush();
        return true;
      }
      fn.process(msg.seqid, iprot, oprot);
      return true;
    }

    private class isBeautiful implements ProcessFunction {
      public void process(int seqid, TProtocol iprot, TProtocol oprot) throws TException
      {
        isBeautiful_args args = new isBeautiful_args();
        try {
          args.read(iprot);
        } catch (TProtocolException e) {
          iprot.readMessageEnd();
          TApplicationException x = new TApplicationException(TApplicationException.PROTOCOL_ERROR, e.getMessage());
          oprot.writeMessageBegin(new TMessage("isBeautiful", TMessageType.EXCEPTION, seqid));
          x.write(oprot);
          oprot.writeMessageEnd();
          oprot.getTransport().flush();
          return;
        }
        iprot.readMessageEnd();
        isBeautiful_result result = new isBeautiful_result();
        result.success = iface_.isBeautiful(args.request);
        
        oprot.writeMessageBegin(new TMessage("isBeautiful", TMessageType.REPLY, seqid));
        result.write(oprot);
        oprot.writeMessageEnd();
        oprot.getTransport().flush();
      }
    }
  }

  public static class Service extends com.twitter.finagle.Service<byte[], byte[]> {
    private final ServiceIface iface;
    private final TProtocolFactory protocolFactory;
    protected HashMap<String, Function2<TProtocol, Integer, Future<byte[]>>> functionMap = new HashMap<String, Function2<TProtocol, Integer, Future<byte[]>>>();
    public Service(final ServiceIface iface, final TProtocolFactory protocolFactory) {
      this.iface = iface;
      this.protocolFactory = protocolFactory;
      functionMap.put("isBeautiful", new Function2<TProtocol, Integer, Future<byte[]>>() {
        public Future<byte[]> apply(final TProtocol iprot, final Integer seqid) {
          isBeautiful_args args = new isBeautiful_args();
          try {
            args.read(iprot);
          } catch (TProtocolException e) {
            try {
              iprot.readMessageEnd();
              TApplicationException x = new TApplicationException(TApplicationException.PROTOCOL_ERROR, e.getMessage());
              TMemoryBuffer memoryBuffer = new TMemoryBuffer(512);
              TProtocol oprot = protocolFactory.getProtocol(memoryBuffer);

              oprot.writeMessageBegin(new TMessage("isBeautiful", TMessageType.EXCEPTION, seqid));
              x.write(oprot);
              oprot.writeMessageEnd();
              oprot.getTransport().flush();
              byte[] buffer = Arrays.copyOfRange(memoryBuffer.getArray(), 0, memoryBuffer.length());
              return Future.value(buffer);
            } catch (Exception e1) {
              return Future.exception(e1);
            }
          } catch (Exception e) {
            return Future.exception(e);
          }

          try {
            iprot.readMessageEnd();
          } catch (Exception e) {
            return Future.exception(e);
          }
          Future<BeautifulBreedResponse> future;
          try {
            future = iface.isBeautiful(args.request);
          } catch (Exception e) {
            future = Future.exception(e);
          }

          try {
            return future.flatMap(new Function<BeautifulBreedResponse, Future<byte[]>>() {
              public Future<byte[]> apply(BeautifulBreedResponse value) {
                isBeautiful_result result = new isBeautiful_result();
                result.success = value;
                result.setSuccessIsSet(true);

                try {
                  TMemoryBuffer memoryBuffer = new TMemoryBuffer(512);
                  TProtocol oprot = protocolFactory.getProtocol(memoryBuffer);

                  oprot.writeMessageBegin(new TMessage("isBeautiful", TMessageType.REPLY, seqid));
                  result.write(oprot);
                  oprot.writeMessageEnd();

                  return Future.value(Arrays.copyOfRange(memoryBuffer.getArray(), 0, memoryBuffer.length()));
                } catch (Exception e) {
                  return Future.exception(e);
                }
              }
            }).rescue(new Function<Throwable, Future<byte[]>>() {
              public Future<byte[]> apply(Throwable t) {
                return Future.exception(t);
              }
            });
          } catch (Exception e) {
            return Future.exception(e);
          }
        }
      });
    }

    public Future<byte[]> apply(byte[] request) {
      TTransport inputTransport = new TMemoryInputTransport(request);
      TProtocol iprot = protocolFactory.getProtocol(inputTransport);

      TMessage msg;
      try {
        msg = iprot.readMessageBegin();
      } catch (Exception e) {
        return Future.exception(e);
      }

      Function2<TProtocol, Integer, Future<byte[]>> fn = functionMap.get(msg.name);
      if (fn == null) {
        try {
          TProtocolUtil.skip(iprot, TType.STRUCT);
          iprot.readMessageEnd();
          TApplicationException x = new TApplicationException(TApplicationException.UNKNOWN_METHOD, "Invalid method name: '"+msg.name+"'");
          TMemoryBuffer memoryBuffer = new TMemoryBuffer(512);
          TProtocol oprot = protocolFactory.getProtocol(memoryBuffer);
          oprot.writeMessageBegin(new TMessage(msg.name, TMessageType.EXCEPTION, msg.seqid));
          x.write(oprot);
          oprot.writeMessageEnd();
          oprot.getTransport().flush();
          return Future.value(Arrays.copyOfRange(memoryBuffer.getArray(), 0, memoryBuffer.length()));
        } catch (Exception e) {
          return Future.exception(e);
        }
      }

      return fn.apply(iprot, msg.seqid);
    }
  }

  public static class isBeautiful_args implements TBase<isBeautiful_args, isBeautiful_args._Fields>, java.io.Serializable, Cloneable {
  private static final TStruct STRUCT_DESC = new TStruct("isBeautiful_args");

  private static final TField REQUEST_FIELD_DESC = new TField("request", TType.STRUCT, (short)1);


  public BeautifulBreedRequest request;

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements TFieldIdEnum {
    REQUEST((short)1, "request");
  
    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();
  
    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }
  
    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // REQUEST
  	return REQUEST;
        default:
  	return null;
      }
    }
  
    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }
  
    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }
  
    private final short _thriftId;
    private final String _fieldName;
  
    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }
  
    public short getThriftFieldId() {
      return _thriftId;
    }
  
    public String getFieldName() {
      return _fieldName;
    }
  }


  // isset id assignments

  public static final Map<_Fields, FieldMetaData> metaDataMap;
  static {
    Map<_Fields, FieldMetaData> tmpMap = new EnumMap<_Fields, FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.REQUEST, new FieldMetaData("request", TFieldRequirementType.DEFAULT,
      new StructMetaData(TType.STRUCT, BeautifulBreedRequest.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    FieldMetaData.addStructMetaDataMap(isBeautiful_args.class, metaDataMap);
  }


  public isBeautiful_args() {
  }

  public isBeautiful_args(
    BeautifulBreedRequest request)
  {
    this();
    this.request = request;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public isBeautiful_args(isBeautiful_args other) {
    if (other.isSetRequest()) {
      this.request = new BeautifulBreedRequest(other.request);
    }
  }

  public isBeautiful_args deepCopy() {
    return new isBeautiful_args(this);
  }

  @Override
  public void clear() {
    this.request = null;
  }

  public BeautifulBreedRequest getRequest() {
    return this.request;
  }

  public isBeautiful_args setRequest(BeautifulBreedRequest request) {
    this.request = request;
    
    return this;
  }

  public void unsetRequest() {
    this.request = null;
  }

  /** Returns true if field request is set (has been asigned a value) and false otherwise */
  public boolean isSetRequest() {
    return this.request != null;
  }

  public void setRequestIsSet(boolean value) {
    if (!value) {
      this.request = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case REQUEST:
      if (value == null) {
        unsetRequest();
      } else {
        setRequest((BeautifulBreedRequest)value);
      }
      break;
    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case REQUEST:
      return getRequest();
    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case REQUEST:
      return isSetRequest();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof isBeautiful_args)
      return this.equals((isBeautiful_args)that);
    return false;
  }

  public boolean equals(isBeautiful_args that) {
    if (that == null)
      return false;
    boolean this_present_request = true && this.isSetRequest();
    boolean that_present_request = true && that.isSetRequest();
    if (this_present_request || that_present_request) {
      if (!(this_present_request && that_present_request))
        return false;
      if (!this.request.equals(that.request))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();
    boolean present_request = true && (isSetRequest());
    builder.append(present_request);
    if (present_request)
      builder.append(request);
    return builder.toHashCode();
  }

  public int compareTo(isBeautiful_args other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    isBeautiful_args typedOther = (isBeautiful_args)other;

    lastComparison = Boolean.valueOf(isSetRequest()).compareTo(typedOther.isSetRequest());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRequest()) {
      lastComparison = TBaseHelper.compareTo(this.request, typedOther.request);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }


  public void read(TProtocol iprot) throws TException {
    TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == TType.STOP) {
        break;
      }
      switch (field.id) {
        case 1: // REQUEST
          if (field.type == TType.STRUCT) {
            this.request = new BeautifulBreedRequest();
            this.request.read(iprot);
          } else {
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          TProtocolUtil.skip(iprot, field.type);
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();

    // check for required fields of primitive type, which can't be checked in the validate method
    validate();
  }

  public void write(TProtocol oprot) throws TException {
    validate();
    
    oprot.writeStructBegin(STRUCT_DESC);
    if (this.request != null) {
      oprot.writeFieldBegin(REQUEST_FIELD_DESC);
      this.request.write(oprot);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("isBeautiful_args(");
    boolean first = true;
    sb.append("request:");
    if (this.request == null) {
      sb.append("null");
    } else {
      sb.append(this.request);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
  }
}

  public static class isBeautiful_result implements TBase<isBeautiful_result, isBeautiful_result._Fields>, java.io.Serializable, Cloneable {
  private static final TStruct STRUCT_DESC = new TStruct("isBeautiful_result");

  private static final TField SUCCESS_FIELD_DESC = new TField("success", TType.STRUCT, (short)0);


  public BeautifulBreedResponse success;

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements TFieldIdEnum {
    SUCCESS((short)0, "success");
  
    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();
  
    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }
  
    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 0: // SUCCESS
  	return SUCCESS;
        default:
  	return null;
      }
    }
  
    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }
  
    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }
  
    private final short _thriftId;
    private final String _fieldName;
  
    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }
  
    public short getThriftFieldId() {
      return _thriftId;
    }
  
    public String getFieldName() {
      return _fieldName;
    }
  }


  // isset id assignments

  public static final Map<_Fields, FieldMetaData> metaDataMap;
  static {
    Map<_Fields, FieldMetaData> tmpMap = new EnumMap<_Fields, FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SUCCESS, new FieldMetaData("success", TFieldRequirementType.DEFAULT,
      new StructMetaData(TType.STRUCT, BeautifulBreedResponse.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    FieldMetaData.addStructMetaDataMap(isBeautiful_result.class, metaDataMap);
  }


  public isBeautiful_result() {
  }

  public isBeautiful_result(
    BeautifulBreedResponse success)
  {
    this();
    this.success = success;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public isBeautiful_result(isBeautiful_result other) {
    if (other.isSetSuccess()) {
      this.success = new BeautifulBreedResponse(other.success);
    }
  }

  public isBeautiful_result deepCopy() {
    return new isBeautiful_result(this);
  }

  @Override
  public void clear() {
    this.success = null;
  }

  public BeautifulBreedResponse getSuccess() {
    return this.success;
  }

  public isBeautiful_result setSuccess(BeautifulBreedResponse success) {
    this.success = success;
    
    return this;
  }

  public void unsetSuccess() {
    this.success = null;
  }

  /** Returns true if field success is set (has been asigned a value) and false otherwise */
  public boolean isSetSuccess() {
    return this.success != null;
  }

  public void setSuccessIsSet(boolean value) {
    if (!value) {
      this.success = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case SUCCESS:
      if (value == null) {
        unsetSuccess();
      } else {
        setSuccess((BeautifulBreedResponse)value);
      }
      break;
    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SUCCESS:
      return getSuccess();
    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case SUCCESS:
      return isSetSuccess();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof isBeautiful_result)
      return this.equals((isBeautiful_result)that);
    return false;
  }

  public boolean equals(isBeautiful_result that) {
    if (that == null)
      return false;
    boolean this_present_success = true && this.isSetSuccess();
    boolean that_present_success = true && that.isSetSuccess();
    if (this_present_success || that_present_success) {
      if (!(this_present_success && that_present_success))
        return false;
      if (!this.success.equals(that.success))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();
    boolean present_success = true && (isSetSuccess());
    builder.append(present_success);
    if (present_success)
      builder.append(success);
    return builder.toHashCode();
  }

  public int compareTo(isBeautiful_result other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    isBeautiful_result typedOther = (isBeautiful_result)other;

    lastComparison = Boolean.valueOf(isSetSuccess()).compareTo(typedOther.isSetSuccess());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSuccess()) {
      lastComparison = TBaseHelper.compareTo(this.success, typedOther.success);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }


  public void read(TProtocol iprot) throws TException {
    TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == TType.STOP) {
        break;
      }
      switch (field.id) {
        case 0: // SUCCESS
          if (field.type == TType.STRUCT) {
            this.success = new BeautifulBreedResponse();
            this.success.read(iprot);
          } else {
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          TProtocolUtil.skip(iprot, field.type);
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();

    // check for required fields of primitive type, which can't be checked in the validate method
    validate();
  }

  public void write(TProtocol oprot) throws TException {
    oprot.writeStructBegin(STRUCT_DESC);
    if (this.isSetSuccess()) {
      oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
      this.success.write(oprot);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("isBeautiful_result(");
    boolean first = true;
    sb.append("success:");
    if (this.success == null) {
      sb.append("null");
    } else {
      sb.append(this.success);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
  }
}


}