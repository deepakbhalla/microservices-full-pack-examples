
# Microservices with Spring Cloud Eureka Service Registry and Discovery

This project has two services -

* service-registry
  (https://github.com/deepakbhalla/microservices-full-pack-examples/tree/master/microservices_with_spring_cloud_eureka/sevice-registry)
* order-service 
  (https://github.com/deepakbhalla/microservices-full-pack-examples/tree/master/microservices_getting_started/order-service)
* payment-service 
  (https://github.com/deepakbhalla/microservices-full-pack-examples/tree/master/microservices_getting_started/payment-service)


## Eureka Server
Service Registry is the Eureka Server which acts a registry of all the microservice applications. It exposes a dashboard at path 'http://localhost:8761/' by default.

## Eureka Clients
Order Service and Payment Service register themselves as Eureka Clients.
 
Order Service makes a call to Payment service using 'Rest Template' and uses it's application name registered with Eureka Server which is 'PAYMENT-SERVICE'.

## Order service 
- Accepts the order request and updates ORDER_TB table which is present in h2 database of this service.
- Makes a call to Payment Service which acts as 'payment gateway' to make a payment against this order.

## Payment Service
- Accepts a call from Order Service or any other client.
- Processes payment against the order in request
- Send back response with payment status, transaction id and other details back to the calling service/client.

## Testing Screenshots

* Eureka Server Dashboard

![image-text](screenshots/1_eureka_server_registered_services.png)

* H2 Database of Payment Service

![image-text](screenshots/2_order_service_calling_payment_service.png)

* Order Service Call Request (which internally calls Payment Service)

![image-text](screenshots/3_order_service_h2_post_service_call.png)

* H2 Database of Order Service post order has been placed

![image-text](screenshots/4_payment_service_h2_post_service_call.png)
