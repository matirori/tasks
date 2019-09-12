package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@Transactional
public class TrelloMapperTestSuite {
    private static List<TrelloListDto> trelloListDto = new ArrayList<>();
    private static List<TrelloList> trelloList = new ArrayList<>();

    private TrelloMapper trelloMapper;

    @Before
    public void init() {
        trelloMapper = new TrelloMapper();
    }

    @Test
    public void testMapToList() {
        List<TrelloListDto> trelloListDto = new ArrayList<>();
        List<TrelloList> trelloList = new ArrayList<>();
        trelloListDto.add(new TrelloListDto("Id1", "Name1", false));
        trelloList.add(new TrelloList("Id1", "Name1", false));


        // Given
        List<TrelloListDto> givenList = trelloListDto;
        List<TrelloList> expectedList = trelloList;

        // When
        List<TrelloList> mapResult = trelloMapper.mapToList(givenList);

        // Then
        assertEquals(expectedList, mapResult);
    }

    @Test
    public void testMapToListDto() {
        List<TrelloListDto> trelloListDto = new ArrayList<>();
        List<TrelloList> trelloList = new ArrayList<>();
        trelloListDto.add(new TrelloListDto("Id1", "Name1", false));
        trelloList.add(new TrelloList("Id1", "Name1", false));

        // Given
        List<TrelloList> givenList = trelloList;
        List<TrelloListDto> expectedList = trelloListDto;

        //When
        List<TrelloListDto> mapResult = trelloMapper.mapToListDto(givenList);

        //Then
        assertEquals(expectedList, mapResult);
    }

    @Test
    public void testMapToBoards() {
        List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();
        List<TrelloBoard> trelloBoardList = new ArrayList<>();
        trelloBoardDtoList.add(new TrelloBoardDto("Id1", "Name1", trelloListDto));
        trelloBoardList.add(new TrelloBoard("Id1", "Name1", trelloList));
        // Given
        List<TrelloBoardDto> givenList = trelloBoardDtoList;
        List<TrelloBoard> expectedList = trelloBoardList;

        // When
        List<TrelloBoard> mapResult = trelloMapper.mapToBoards(givenList);

        // Then
        assertEquals(expectedList, mapResult);
    }

    @Test
    public void testMapToBoardsDto() {
        List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();
        List<TrelloBoard> trelloBoardList = new ArrayList<>();
        trelloBoardDtoList.add(new TrelloBoardDto("Id1", "Name1", trelloListDto));
        trelloBoardList.add(new TrelloBoard("Id1", "Name1", trelloList));
        // Given
        List<TrelloBoard> givenList = trelloBoardList;
        List<TrelloBoardDto> expectedList = trelloBoardDtoList;

        // When
        List<TrelloBoardDto> mapResult = trelloMapper.mapToBoardsDto(givenList);

        // Then
        assertEquals(expectedList, mapResult);
    }

    @Test
    public void testMapToCardDto() {
        // Given
        TrelloCard givenCard1 = new TrelloCard("Name1", "Description1", "Position1", "ListId1");
        TrelloCardDto expectedCardDto1 = new TrelloCardDto("Name1", "Description1", "Position1", "ListId1");

        // When
        TrelloCardDto mapResult1 = trelloMapper.mapCardDto(givenCard1);

        // Then
        assertEquals(expectedCardDto1, mapResult1);
    }

    @Test
    public void testMapToCard() {
        // Given
        TrelloCardDto givenCardDto1 = new TrelloCardDto("Name1", "Description1", "Position1", "ListId1");
        TrelloCard expectedCard1 = new TrelloCard("Name1", "Description1", "Position1", "ListId1");

        // When
        TrelloCard mapResult1 = trelloMapper.mapToCard(givenCardDto1);

        // Then
        assertEquals(expectedCard1, mapResult1);

    }

}