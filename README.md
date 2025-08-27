# finbank-backend

## 🔗 서비스 플로우 다이어그램

```mermaid
flowchart TD
    %% 노드 정의
    User[사용자] --> Gateway[API Gateway<br>JWT 인증/인가]
    Gateway --> Payment[Payment Service<br>DB 트랜잭션<br>Redis 캐시<br>Kafka 이벤트 발행]
    Payment --> Kafka[(Kafka Broker)]
    Kafka --> Notification[Notification Service<br>이벤트 소비 후 알림 발송]
    Kafka --> Settlement[Settlement Service<br>거래 정산 배치]

    %% 인프라 및 모니터링
    subgraph Infra[Infra & Observability]
        Docker[(Docker/K8s 배포)]
        Prometheus[(Prometheus & Grafana)]
    end
    
    %% 관계
    Payment --- Docker
    Kafka --- Prometheus
    Notification --- Docker
    Settlement --- Docker
