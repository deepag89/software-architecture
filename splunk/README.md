------------------------------------------------------------------------------------------------------------------------
                                            Forwarder
------------------------------------------------------------------------------------------------------------------------
Forwarders represent a much more robust solution for data forwarding than raw network feeds, with their capabilities for:

1. Tagging of metadata (source, source type, and host)
2. Configurable buffering
3. Data compression
4. SSL security
5. Use of any available network ports

The universal forwarder
-----------------------
The sole purpose of the universal forwarder is to forward data. Unlike a full Splunk instance, you cannot use the universal forwarder to index or search data. 
To achieve higher performance and a lighter footprint, it has several limitations:

1. The universal forwarder cannot search, index, or produce alerts with data.
2. The universal forwarder does not parse data. You cannot use it to route data to different Splunk indexers based on its contents.

 It can also forward data to another forwarder as an intermediate step before sending the data onward to an indexer.
 
 Heavy and light forwarders
 --------------------------
 A heavy forwarder parses data before forwarding it and can route data based on criteria such as source or type of event.
 
 Types of forwarder data
 -----------------------
 Forwarders can transmit three types of data:
 
 Raw
 Unparsed
 Parsed
 
 Universal forwarders can send raw or unparsed data. Heavy forwarders can send raw or parsed data.
 
 With raw data, the forwarder sends the data unaltered over a TCP stream. it does not convert the data into the Splunk communications format. The forwarder collects the data and sends it on. This is particularly useful for sending data to a non-Splunk system.
 
 With unparsed data, a universal forwarder performs minimal processing. It does not examine the data stream, but it does tag the stream with metadata to identify source, source type, and host. It also divides the data stream into 64-kilobyte blocks and performs some rudimentary timestamping on the stream that the receiving indexer can use in case the events themselves have no discernible timestamps. The universal forwarder does not identify, examine, or tag individual events except when you configure it to parse files with structure data (such as comma-separated value files.)
 
 With parsed data, a heavy forwarder breaks the data into individual events, which it tags and then forwards to a Splunk indexer. It can also examine the events. Because the data has been parsed, the forwarder can perform conditional routing based on event data, such as field values.
 
 The parsed and unparsed formats are both referred to as cooked data, to distinguish them from raw data.
 
 Load balancing
 ---------------
 
Forwarders perform automatic load balancing, in which the forwarder switches receivers at set time intervals. If parsing is turned on (for a heavy forwarder), the switching will occur at event boundaries.

Routing and filtering
---------------------
In data routing, a forwarder routes events to specific hosts, based on criteria such as source, source type, or patterns in the events themselves. Routing at the event level requires a heavy forwarder.
https://docs.splunk.com/Documentation/Splunk/6.5.0/Forwarding/Forwarderdeploymenttopologies

Intermediate forwarding
---------------------
To handle some advanced use cases, you might want to insert an intermediate forwarder between a group of forwarders and the indexer. In this type of scenario, the originating forwarders send data to a consolidating forwarder, which then forwards the data on to an indexer. In some cases, the intermediate forwarders also index the data.

Typical use cases are situations where you need an intermediate index, either for "store-and-forward" requirements or to enable localized searching. (In this case, you would need to use a heavy forwarder.) You can also use an intermediate forwarder if you have some need to limit access to the indexer machine; for instance, for security reasons.