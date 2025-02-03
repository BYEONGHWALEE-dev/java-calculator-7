package calculator;

import java.util.ArrayList;
import java.util.List;

public class CalculFunc {

    // 숫자 저장소
    List<Integer> finalNum = new ArrayList<>();

    // 제곱 필드 생성
    NumPower NumPower = new NumPower();

    // 메소드
    // 숫자 추출하는 함수
    public List<Integer> extractNumber(List<Character> numList, List<Character> sepList) {

        // 임시 숫자 저장소
        List<Integer> tempNum = new ArrayList<>();

        if(numList.isEmpty()){
            return finalNum;
        }

        else{

            for(char c: numList) {

                if(Character.isDigit(c)){
                    tempNum.add(Character.getNumericValue(c));
                }
                else{
                    // 구분자 두번 나오거나 첫번째로 구분자 나오는것 금지
                    if((sepList.contains(c)) && !tempNum.isEmpty()){

                        int temp = 0;
                        int tempNumSize = tempNum.size();

                        for(int i = 0; i < tempNumSize; i++){
                            temp += tempNum.get(i) * NumPower.tenPower(tempNumSize - 1 - i);
                        }

                        finalNum.add(temp);

                        // tempNum 리스트 초기화
                        tempNum.clear();
                    }
                    else {
                        throw new IllegalArgumentException("잘못된 값을 입력하였습니다." + c);
                    }
                }

            }
        }
        return finalNum;
    }

    // 더하는 함수
    public int addAllNum(List<Integer> numList) {

        // return 할 필드
        int result = 0;

        for(int i : numList){
            result += i;
        }

        return result;
    }

    // 구분자 지정인지 아닌지 검증(true = 구분자 지정)
    public boolean validateList(List<Character> numList) {

        boolean result = true;

        if(numList.size() >= 4) {
            char a = numList.get(0);
            char b = numList.get(1);
            char c = numList.get(3);

            char sep = numList.get(2);

            if(a == '/' && b == '/' && c == '\n' && !Character.isDigit(sep)) {

                return true;
            }

            else {
                return false;
            }
        }

        else {
            return false;
        }
    }

    // 구분자 추출 함수(구분자 지정파트 삭제)
    public Character pullSeperator(List<Character> numList) {

        // 구분자
        char sep = numList.get(2);

        // 구분자 지정파트 삭제
        for(int i = 0; i < 4; i++){
            numList.removeFirst();
        }

        return sep;
    }

}
