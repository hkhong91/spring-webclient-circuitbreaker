# Spring WebClient Circuit Breaker Sample

https://resilience4j.readme.io/docs/circuitbreaker

### CircuitBreaker

|config|default|description|
|---|---|---|
|registerHealthIndicator|false|/actuator/health로 CircuitBreaker 모니터링|
|slidingWindowSize|100|요청의 결과를 기록하기 위한 윈도우의 크기|
|minimumNumberOfCalls|100|CircuitBreaker가 에러율과 지연율을 계산하기 전에 요구되는 최소한의 요청 수|
|failureRateThreshold|50|에러율보다 클 경우 Circuit Open|
|slowCallRateThreshold|100|지연율보다 클 경우 Circuit Open|
|slowCallDurationThreshold|60s|지연으로 간주하는 시간|
|waitDurationInOpenState|60s|CircuitBreaker가 Open인 경우 Half-Open으로 돌아오는 시간|
|recordException|throwable -> true|Exception이 실패로 기록될지 정의 (실패:true, 성공:false)|
|recordExceptions|-|실패로 기록될 Exception list|
|ignoreException|throwable -> false|Exception이 무시될지 정의 (무시:true, 실패카운트:false)|
|ignoreExceptions|-|성공과 실패 모두 기록되지 않는 Exception list|