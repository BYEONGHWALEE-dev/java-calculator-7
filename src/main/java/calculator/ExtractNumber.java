package calculator;

import java.util.ArrayList;
import java.util.List;

public class ExtractNumber {


    // 숫자 저장소
    List<Integer> finalNum = new ArrayList<>();

    // 제곱 필드 생성
    NumPower NumPower = new NumPower();

    // 메소드

    public List<Integer> extractNumber(List<Character> numList) {

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
                    if(c == '/' || c == ';'){

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
                        throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
                    }
                }

            }
        }
        return finalNum;
    }
}
