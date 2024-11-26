# java-convenience-store-precourse
구매자의 할인 혜택과 재고 상황을 고려하여 최종 결제 금액을 계산하고 안내하는 결제 시스템을 구현한다.   

---
## **구현할 기능 목록 + 예외 처리 항목**

1. 첫 안내를 위한 파일 준비
- [x]  구현에 필요한 상품 목록과 행사 목록 불러오기 (형식 유지, 값 수정 가능)
  - [x]  불러오기 실패 시 예외처리

2. 첫 안내
- [x]  환영 인사와 함께 상품명, 가격, 프로모션 이름, 재고 출력.
  - [x]  재고가 0이라면 `재고 없음` 출력

3. 구매 상품 및 수량 조사
- [x]  구매할 상품과 수량 입력 받기
  - [x]  상품명, 수량은 하이픈(-)으로, 개별 상품은 대괄호([])로 묶어 쉼표(,)로 구분
  - [x]  형식이 지켜지지 않았을 시 다시 입력 받기
  - [x]  각 상품의 재고 수량 고려하여 결제 가능 여부 확인.
  - [ｘ]  결제된 수량만큼 상품의 재고 차감

4. 프로모션
고객이 프로모션 적용 가능 상품의 buy를 충족하고 get을 충족하지 않은 경우, get의 수량만큼 추가로 가져갈 건지  y or n으로 입력받는다.
 - [ ] y를 입력했을 때 (추가로 가져가는 경우)
	- [ ] 프로모션 재고가 부족
		- [ ] 일부 수량을 혜택 없이 결제해야 하는 경우, 일부 수량에 대해 정가로 결제할지 여부에 대한 안내 메시지를 출력하고 사용자에게 y or n로 입력받는다.
			- [ ] y라면, 정가 개수만큼 productPurchases의 개수를 추가하고 금액을 업데이트 한다.
	- [ ] 프로모션 재고가 부족하지 않은 경우
		- [ ] 추가로 가져오겠다 선택한 경우, 혜택 개수만큼 productPurchases의 개수를 추가하고 금액은 추가하지 않는다.  
- [ ] n을 입력했을 때 (추가로 가져가지 않는 경우)  (ex. 1+1이라서 1개 더 가져와야 하는데 1개만 사는 경우)
	- [ ] 원래 사용자가 구매했던 물품 구매 개수만큼만 productions.md를 업데이트.
      - [ ]  형식이 지켜지지 않았을 시 다시 입력 받기
- [ ]  프로모션은 N+1 형태로 진행되며, 동일 상품에 여러 프로모션이 적용되지 않는다.
- [ ]  프로모션 혜택은 프로모션 재고 내에서만 적용 가능
- [ ]  프로모션 기간 중이라면, 프로모션 재고를 우선적 차감.
  - [ ]  부족할 경우 일반 재고 사용

5. 멤버십
- [ｘ]  멤버십 할인 적용 여부를 입력받는다.  (Y/N, 소문자 허용)
  - [ｘ]  형식이 지켜지지 않았을 시 다시 입력 받기
  - [ｘ]  Y : 멤버십 회원은 프로모션 미적용 금액의 30% 할인
    - [ｘ]  최대 할인 금액은 8,000원
    - [ ]  멤버십 회원인지 확인 (내부적으로)
      - [ ]  아니라면 회원이 아니라는 메시지 출력
      - [ ]  맞다면 그대로 진행.

6. 영수증 출력
- [ ]  영수증을 출력한다.
  - [ ]  구매한 상품명, 수량, 가격
  - [ ]  프로모션 증정 상품 내역
  - [ ]  금액 정보
    - [ ]  총 액과 총 수량
    - [ ]  프로모션 행사 할인 금액
    - [ ]  멤버십 할인 금액
    - [ ]  최종 결제 금액

7. 추가 구매
- [ ]  추가 구매 여부를 입력받는다.  (Y/N, 소문자 허용)
  - [ ]  형식이 지켜지지 않았을 시 다시 입력 받기

---

### Functional requirements
- [ ] 사용자가 입력한 상품의 가격과 수량을 기반으로 최종 결제 금액을 계산한다.
  - [ ] 총 구매액은 상품별 가격과 수량을 곱하여 계산.
  - [ ] 프로모션 및 멤버십 할인 정책을 반영하여 최종 결제 금액 산출.
- [ ] 구매 내역과 산출한 금액 정보를 영수증으로 출력.
- [ ] 영수증 출력 후 구매를 진행할지 또는 종료할지 선택.
- [ｘ] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
  - [ｘ] Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

**재고 관리**
- [x] 각 상품의 재고 수량을 고려 하여 결제 가능 여부 확인
- [ｘ] 고객이 상품을 구매할 때마다, 결제된 수량만큼 해당 상품의 재고에서 차감하여 수량을 관리한다.
- [ｘ] 재고를 차감함으로써 시스템은 최신 재고 상태 유지. 다음 고객이 구매할 때 정확한 재고 정보 제공.

**프로모션 할인**
- [ｘ] 오늘 날짜가 프로모션 기간 내에 포함된 경우에만 할인을 적용한다.
- [ｘ] 프로모션은 N개 구매 시 1개 무료 증정(Buy N Get 1 Free)의 형태로 진행된다.
- [ｘ] 1+1 또는 2+1 프로모션이 각각 지정된 상품에 적용되며, 동일 상품에 여러 프로모션이 적용되지 않는다.
- [ ] 프로모션 혜택은 프로모션 재고 내에서만 적용할 수 있다.
- [ ] 프로모션 기간 중이라면 프로모션 재고를 우선적으로 차감하며, 프로모션 재고가 부족할 경우에는 일반 재고를 사용한다.
- [ ] 프로모션 적용이 가능한 상품에 대해 고객이 해당 수량보다 적게 가져온 경우, 필요한 수량을 추가로 가져오면 혜택을 받을 수 있음을 안내한다.
- [ ] 프로모션 재고가 부족하여 일부 수량을 프로모션 혜택 없이 결제해야 하는 경우, 일부 수량에 대해 정가로 결제하게 됨을 안내한다.

**멤버십 할인**
- [ ] 멤버십 회원은 프로모션 미적용 금액의 30%를 할인받는다.
- [ ] 프로모션 적용 후 남은 금액에 대해 멤버십 할인을 적용한다.
- [ ] 멤버십 할인의 최대 한도는 8,000원이다.

**영수증 출력**
- [ ] 영수증은 고객의 구매 내역과 할인을 요약하여 출력한다.
- [ ] 영수증 항목은 아래와 같다. 
  - [ ] 구매 상품 내역: 구매한 상품명, 수량, 가격
  - [ ] 증정 상품 내역: 프로모션에 따라 무료로 제공된 증정 상품의 목록 
  - [ ] 금액 정보 
    - [ ] 총구매액: 구매한 상품의 총 수량과 총 금액
    - [ ] 행사할인: 프로모션에 의해 할인된 금액
    - [ ] 멤버십할인: 멤버십에 의해 추가로 할인된 금액
    - [ ] 내실돈: 최종 결제 금액
- [ ] 영수증의 구성 요소를 보기 좋게 정렬하여 고객이 쉽게 금액과 수량을 확인할 수 있게 한다.


### I/O requirements
- [x] 구현에 필요한 상품 목록과 행사 목록을 파일 입출력을 통해 불러온다.
  - src/main/resources/products.md과 src/main/resources/promotions.md 파일을 이용한다. 
  - 두 파일 모두 내용의 형식을 유지한다면 값은 수정할 수 있다.
- [x] 구매할 상품과 수량을 입력 받는다. 상품명, 수량은 하이픈(-)으로, 개별 상품은 대괄호([])로 묶어 쉼표(,)로 구분한다.
    ```shell
  [콜라-10],[사이다-3]
  ```
- [ ] 프로모션 적용이 가능한 상품에 대해 고객이 해당 수량보다 적게 가져온 경우, 그 수량만큼 추가 여부를 입력받는다.
  - Y : 추가함
  - N : 추가 안 함
- [ ] 프로모션 재고가 부족하여 일부 수량을 프로모션 혜택 없이 결제해야 하는 경우, 일부 수량에 대해 정가로 결제할지 여부를 입력받는다.
  - Y : 일부 수량에 대해 정가로 결제.
  - N : 정가로 결제해야하는 수량만큼 제외한 후 결제 진행.
- [ｘ] 멤버십 할인 적용 여부를 입력받는다.
  - Y : 적용함.
  - N : 적용 안 함.
- [ ] 추가 구매 여부를 입력받는다.
  - Y : 재고가 업데이트 된 상품 목록을 확인한 후, 추가로 구매를 진행.
  - N : 구매 종료


### Output
환영 인사와 함께 상품명, 가격, 프로모션 이름, 재고를 안내한다. 만약 재고가 0개라면 `재고 없음`을 출력한다.
```
안녕하세요. W편의점입니다.
현재 보유하고 있는 상품입니다.

- 콜라 1,000원 10개 탄산2+1
- 콜라 1,000원 10개
- 사이다 1,000원 8개 탄산2+1
- 사이다 1,000원 7개
- 오렌지주스 1,800원 9개 MD추천상품
- 오렌지주스 1,800원 재고 없음
- 탄산수 1,200원 5개 탄산2+1
- 탄산수 1,200원 재고 없음
- 물 500원 10개
- 비타민워터 1,500원 6개
- 감자칩 1,500원 5개 반짝할인
- 감자칩 1,500원 5개
- 초코바 1,200원 5개 MD추천상품
- 초코바 1,200원 5개
- 에너지바 2,000원 5개
- 정식도시락 6,400원 8개
- 컵라면 1,700원 1개 MD추천상품
- 컵라면 1,700원 10개

구매하실 상품명과 수량을 입력해 주세요. (예: [사이다-2],[감자칩-1])
```
<br>

프로모션 적용이 가능한 상품에 대해 고객이 해당 수량만큼 가져오지 않았을 경우, 혜택에 대한 안내 메시지를 출력한다.
```
현재 {상품명}은(는) 1개를 무료로 더 받을 수 있습니다. 추가하시겠습니까? (Y/N)
```
<br>

프로모션 재고가 부족하여 일부 수량을 프로모션 혜택 없이 결제해야 하는 경우, 일부 수량에 대해 정가로 결제할지 여부에 대한 안내 메시지를 출력한다.
```
현재 {상품명} {수량}개는 프로모션 할인이 적용되지 않습니다. 그래도 구매하시겠습니까? (Y/N)
```
<br>

멤버십 할인 적용 여부를 확인하기 위해 안내 문구를 출력한다.
```
멤버십 할인을 받으시겠습니까? (Y/N)
```
<br>

구매 상품 내역, 증정 상품 내역, 금액 정보를 출력한다.
```
==============W 편의점================
상품명		수량	금액
콜라		3 	3,000
에너지바 		5 	10,000
=============증	정===============
콜라		1
====================================
총구매액		8	13,000
행사할인			-1,000
멤버십할인			-3,000
내실돈			 9,000
```
<br>

추가 구매 여부를 확인하기 위해 안내 문구를 출력한다.
```
감사합니다. 구매하고 싶은 다른 상품이 있나요? (Y/N)
```
<br>

사용자가 잘못된 값을 입력했을 때, "[ERROR]"로 시작하는 오류 메시지와 함께 상황에 맞는 안내를 출력한다.
- 구매할 상품과 수량 형식이 올바르지 않은 경우: [ERROR] 올바르지 않은 형식으로 입력했습니다. 다시 입력해 주세요.
- 존재하지 않는 상품을 입력한 경우: [ERROR] 존재하지 않는 상품입니다. 다시 입력해 주세요.
- 구매 수량이 재고 수량을 초과한 경우: [ERROR] 재고 수량을 초과하여 구매할 수 없습니다. 다시 입력해 주세요.
- 기타 잘못된 입력의 경우: [ERROR] 잘못된 입력입니다. 다시 입력해 주세요.

<br>

##### 실행 결과 예시
```
안녕하세요. W편의점입니다.
현재 보유하고 있는 상품입니다.

- 콜라 1,000원 10개 탄산2+1
- 콜라 1,000원 10개
- 사이다 1,000원 8개 탄산2+1
- 사이다 1,000원 7개
- 오렌지주스 1,800원 9개 MD추천상품
- 오렌지주스 1,800원 재고 없음
- 탄산수 1,200원 5개 탄산2+1
- 탄산수 1,200원 재고 없음
- 물 500원 10개
- 비타민워터 1,500원 6개
- 감자칩 1,500원 5개 반짝할인
- 감자칩 1,500원 5개
- 초코바 1,200원 5개 MD추천상품
- 초코바 1,200원 5개
- 에너지바 2,000원 5개
- 정식도시락 6,400원 8개
- 컵라면 1,700원 1개 MD추천상품
- 컵라면 1,700원 10개

구매하실 상품명과 수량을 입력해 주세요. (예: [사이다-2],[감자칩-1])
[콜라-3],[에너지바-5]

멤버십 할인을 받으시겠습니까? (Y/N)
Y

==============W 편의점================
상품명		수량	금액
콜라		3 	3,000
에너지바 		5 	10,000
=============증	정===============
콜라		1
====================================
총구매액		8	13,000
행사할인			-1,000
멤버십할인			-3,000
내실돈			 9,000

감사합니다. 구매하고 싶은 다른 상품이 있나요? (Y/N)
Y

안녕하세요. W편의점입니다.
현재 보유하고 있는 상품입니다.

- 콜라 1,000원 7개 탄산2+1
- 콜라 1,000원 10개
- 사이다 1,000원 8개 탄산2+1
- 사이다 1,000원 7개
- 오렌지주스 1,800원 9개 MD추천상품
- 오렌지주스 1,800원 재고 없음
- 탄산수 1,200원 5개 탄산2+1
- 탄산수 1,200원 재고 없음
- 물 500원 10개
- 비타민워터 1,500원 6개
- 감자칩 1,500원 5개 반짝할인
- 감자칩 1,500원 5개
- 초코바 1,200원 5개 MD추천상품
- 초코바 1,200원 5개
- 에너지바 2,000원 재고 없음
- 정식도시락 6,400원 8개
- 컵라면 1,700원 1개 MD추천상품
- 컵라면 1,700원 10개

구매하실 상품명과 수량을 입력해 주세요. (예: [사이다-2],[감자칩-1])
[콜라-10]

현재 콜라 4개는 프로모션 할인이 적용되지 않습니다. 그래도 구매하시겠습니까? (Y/N)
Y

멤버십 할인을 받으시겠습니까? (Y/N)
N

==============W 편의점================
상품명		수량	금액
콜라		10 	10,000
=============증	정===============
콜라		2
====================================
총구매액		10	10,000
행사할인			-2,000
멤버십할인			-0
내실돈			 8,000

감사합니다. 구매하고 싶은 다른 상품이 있나요? (Y/N)
Y

안녕하세요. W편의점입니다.
현재 보유하고 있는 상품입니다.

- 콜라 1,000원 재고 없음 탄산2+1
- 콜라 1,000원 7개
- 사이다 1,000원 8개 탄산2+1
- 사이다 1,000원 7개
- 오렌지주스 1,800원 9개 MD추천상품
- 오렌지주스 1,800원 재고 없음
- 탄산수 1,200원 5개 탄산2+1
- 탄산수 1,200원 재고 없음
- 물 500원 10개
- 비타민워터 1,500원 6개
- 감자칩 1,500원 5개 반짝할인
- 감자칩 1,500원 5개
- 초코바 1,200원 5개 MD추천상품
- 초코바 1,200원 5개
- 에너지바 2,000원 재고 없음
- 정식도시락 6,400원 8개
- 컵라면 1,700원 1개 MD추천상품
- 컵라면 1,700원 10개

구매하실 상품명과 수량을 입력해 주세요. (예: [사이다-2],[감자칩-1])
[오렌지주스-1]

현재 오렌지주스은(는) 1개를 무료로 더 받을 수 있습니다. 추가하시겠습니까? (Y/N)
Y

멤버십 할인을 받으시겠습니까? (Y/N)
Y

==============W 편의점================
상품명		수량	금액
오렌지주스		2 	3,600
=============증	정===============
오렌지주스		1
====================================
총구매액		2	3,600
행사할인			-1,800
멤버십할인			-0
내실돈			 1,800

감사합니다. 구매하고 싶은 다른 상품이 있나요? (Y/N)
N
```


### Programming requirements
- [ ] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- [ ] 3항 연산자 금지
- [ ] 메서드가 한 가지 일만 하도록 최대한 작게 구현. (10줄이 넘어가지 않게)
- [ ] JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인
- [ ] else 예약어 금지
  - if 조건절에서 값을 retrun하는 방식으로 구현.
- [ ] Java enum 사용
- [ ] 구현한 기능에 대한 단위 테스트 작성, UI로직 제외
- [ ] 입출력을 담당하는 클래스를 별도로 구현한다.
- [ ] `camp.nextstep.edu.missionutils`에서 제공하는 `DateTimes` 및 `Console` API를 사용하여 구현해야 한다. 
  - 현재 날짜와 시간을 가져오려면 `camp.nextstep.edu.missionutils.DateTimes`의 `now()`를 활용한다.
  - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
