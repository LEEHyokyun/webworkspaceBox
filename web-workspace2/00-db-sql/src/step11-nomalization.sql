/* 
 * DB 정규화
 * - DB table을 설계하는 기법으로, 분할하는 과정을 일컫는다.
 * - 데이터 중복을 최소화하고, 무결성을 보장하기위해 진행한다.
 * 
 * 제 1 정규화(1NF, 1 normal form)
 * > 도메인은 원자값으로 구성되어야 한다.
 * > 도메인은 속성/column을 지칭하는 개념으로, 해당 속성값이 가질 수 있는 값의 범위를 일컫는다.
 * 		ㄴ 성별 = 남 or 여
 * > 원자값은 더이상 쪼갤 수 없는 최소한의 단위 및 값이다.
 * 		ㄴ 즉, column / 속성은 더이상 쪼갤 수 없는, 다시 말해 복수의 속성값이 입력될 수 없다.
 * > 다대다 관계 자체가 1정규화 위배, 이에 따른 유지보수 및 관리가 안되는 상황이다.
 * 		ㄴ 반드시 속성의 원자값, 1정규화 규칙을 준수해야 참조무결성 등 데이터 관리가 가능하다.
 * 
 * 제 2 정규화(2NF)
 * > 부분 함수 종속을 분리하여, 완전 함수 종속 상태로 만든다.
 * > 쉽게 말하면 1차 정규화 후, 세부적으로 정규화를 진행한다.
 * 		ㄴ 교차 엔티티를 생성하는 과정
 * 		ㄴ 부분함수 종속(즉 복합PK에서 1개의 PK에만 해당되는 속성/column들을 다시 별도로 table 생성)
 * 		ㄴ 완전함수 종속(복합PK 모든 PK에 해당하는 속성/column의 경우엔 하나의 table로 유지하거나 따로 구성)
 * 
 * 제 3 정규화(3NF)
 * > 이행 함수 종속을 분리(A->B이면 B->C이고 A->C이다)
 * > 일반속성에 종속적인 속성을 분리한다.
 * 		ㄴ 주문번호 -> 주문일자
 * 		ㄴ 부서번호 -> 부서명, 부서전화, 관리자명
 * > 쉽게 말하면 결국엔 또 다른 table 분리, 주문번호와 부서번호만 있어도 해당 정보들을 조회가능하도록 table 분리.
 * 		ㄴ 비식별관계의 table에 대한 table 분리 과정
 * > 주문서 table에 주문번호를 기본 key로 부서번호, 부서명, 부서전화, 관리자명이 일반 속성으로 있다면
 * 	  부서번호 일반 속성에 부서명, 부서전화, 관리자명이 종속되어있는 상태.
 * 		ㄴ 주문번호 -> 부서번호	-> 	부서명, 관리자명.. 이런 일반 속성에 종속되어있는 속성을 분리하는 것이 3정규화.
**/	