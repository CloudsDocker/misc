# Xaas
[this wiki page](https://simple.wikipedia.org/wiki/Everything_as_a_service) list concepts.
**Everything as a service (EaaS,[1] XaaS,[2] *aaS[3])** is a concept of being able to call up re-usable, fine-grained software components across a network.[4] It is a subset of cloud computing. The most common and successful example is software as a service (SaaS), but the term as a service has been associated and used with many core components of cloud computing including communication, infrastructure, data and platforms.
Key characteristics

Offerings tagged with the as a service suffix have a number of common attributes, including:

- Low barriers to entry is a common method of offerings, with services typically being available to or targeting consumers and small businesses.
- Little or no capital expenditure as infrastructure is owned by the provider.
- Massive scalability is also common, though this is not an absolute requirement and many of the offerings have yet to achieve large scale.
- Multitenancy enables resources (and costs) to be shared among many users.
- Device independence[1] enables users to access systems regardless of what device they are using (e.g. PC, mobile,...etc.).
- Location independence[1] allows users remote access to systems.

Sub-categories

A distinction can be made in this context with the following terminologies.
- Software as a Service (SaaS)
- Platform as a Service (PaaS)
- Infrastructure as a Service (IaaS)

# serverless architecure
a video introduction: 

https://www.oreilly.com/ideas/an-introduction-to-serverless-software-architecture-2016?imm_mid=0ebce3&cmp=em-prog-na-na-newsltr_21061231

# Cloud computing
Cloud computing is an approach to computing that builds on virtualization's efficient **pooling of resources** to create an on-demand, elastic, self-managing virtual infrastructure that can be **allocated dynamically as a service**. Virtualization uncouples applications and information <u>from the complexity of the underlying hardware infrastructure</u>.

Virtualization, in addition to being the underlying technology for cloud computing, enables organizations of all sizes to make improvements in the areas of **flexibility and cost containment**. For example, with server consolidation, one physical server takes on the work of many servers by incorporating multiple servers as virtual machines. Also, ease of management and effective resource use are products of virtualizing the datacenter. When you virtualize your datacenter, management of the infrastructure becomes easier and you use your available infrastructure resources more effectively. Virtualization enables you to create a dynamic and flexible datacenter, and can reduce operating expenses through automation while also **reducing planned and unplanned downtime**.

VMware vSphere **virtualizes and aggregates the underlying physical hardware resources across multiple systems and provides pools of virtual resources to the datacenter**.
Virtualization is a process that breaks the hard connection between the physical hardware and the operating system and applications running on it. After being virtualized in a vSphere virtual machine, the operating system and applications are no longer constrained by the limits imposed by residing on a single physical machine.

**VMware ESXi** : 	A virtualization layer run on physical servers that abstracts processor, memory, storage, and resources into multiple virtual machines.


## Windows Fail Over File Server
### Scale Out File server: this is **active-active**, every nodes of the cluster can accept and server _SMB_(Server Message Block)
###

## Fail Over
### GSS (Cisco Global Site Selector)
The GSS is simply an intelligent DNS-resolution box. It monitors the status of a number of IP addresses and returns answers to DNS queries in a rough effort to balance traffic across multiple geographies.

The traffic flow itself (between the client and the server) never traverses the GSS - the GSS simply tells the client which server to target by resolving a name to an IP address.

So the GSS does not pass name references, or have anything to do with Kerberos. It simply receives a DNS request (UDP port 53), does a bit of analysis, and answers it with an IP address based on how the GSS rule is defined. No HTTP traffic ever hits the GSS.

Finally, the GSS off-loads tasks from traditional DNS (Domain Name Service) servers by taking control of the domain resoltuion process for parts of your domain name space.

## PSTN

The public switched telephone network (PSTN) is the aggregate of the world's circuit-switched telephone networks that are operated by national, regional, or local telephony operators, providing infrastructure and services for public telecommunication. The PSTN consists of telephone lines, fiber optic cables, microwave transmission links, cellular networks, communications satellites, and undersea telephone cables, all interconnected by switching centers, thus allowing most telephones to communicate with each other. Originally a network of fixed-line analog telephone systems, the PSTN is now almost entirely digital in its core network and includes mobile and other networks, as well as fixed telephones

## HSRP
In computer networking, the Hot Standby Router Protocol (HSRP) is a Cisco proprietary redundancy protocol for establishing a fault-tolerant default gateway. The protocol establishes a framework between network routers in order to achieve default gateway failover if the primary gateway becomes inaccessible, in close association with a rapid-converging routing protocol like EIGRP or OSPF. HSRP routers send multicast Hello messages to other routers to notify them of their priorities (which router is preferred) and current status (Active or Standby).


GSLB: Global Server Load Balancing
SLB: Server Load Balances



netezza DB


# Java Object
## Methods in Java
- clone
- equals
- finalize
- getClass
- hashCode
- notify
- notifyAll
- toString
- wait

## Clone
x.clone()!=x
x.clone().getClass()==x.getClass() (but not absolute requirements)
x.clone().equasl(x) (but not absolute requirements)


# Disaster Recovery
- **DRaas**: Disaster Recovery-as-a-Service
- **RPO**: Recovery Point Objective, refers to the point in time in the past to which you will recover
- **RTO**: Recovery Time Objective, refers to the point in time in the future at which you will be up and running again.
- **PTO**: Paid Time Off. PTO is what you take the day after you've sucessfully recovered from your disaster and your business is back up and running at full speed ahead.
- **RCO**: Recovery COnsistency Objective defines a measurement for the consistency of distributed business data within interlinked systems after a disater incident. Similar to terms used in this context are **RCC** Recovery Consistency Charactereristics and **ROG**: recovery object granualarity.

> <------RPO-----Disaster Strikes---RTO----->
Time between RPO and Disater means lost trasnactions
Time between Diaster and RTO means time down
Think of the above diagram as a timeline of events during which a disaster happens. The RPO will be the point to which you will have all data up to that point recovered. The gap between the disaster and the RPO will likely be lost as a result of the disaster.
On the timeline, RTO is the point in the future at which you will be back up and running full speed ahead. The gap between the disaster and the RTO is the timeframe for which your app will be down and non-functioning.
Robinson explains, “If you’re a Tier 1 banking high-transaction application, you will not be able to afford a very high RPO. You will need to have all transactions or real money will be lost as those transactions are lost.”
He continues, “If you are referring to a website, however, which is updated monthly, you’re RPO can be as much as weeks back in time since not much will have changed, if anything. You are more comfortable going farther back in time to recover, and likely you will end up paying less for that RPO.”
And finally, the acronym PTO stands for paid time off. 

## RCO
The term RCO focuses on business data consistency across multiple systems in SOA-driven business applications such as SAP ERP.
While RTO and RPO are absolute per-system values, RCO is expressed as percentage measuring the deviation between actual and targeted state of business data across systems for individual business processes or process groups.

Targeting 100% RCO for a business process (distributed across several systems) would mean that no business data deviation is allowed after a disaster incident whereas any target below 100% allows deviation. Target values for RCO increase with the criticality of the underlying business data: logistics and banking-related business processes are often characterized by higher RCO requirements than those of CRM or HR systems.
