<template>
  <div>
    <p
      style="
        font-family: 'Koreageulggol';
        font-size: 150pt;
        text-decoration-line: none;
        color: red;
      "
    >
      Notice Board
    </p>
    <b-container class="bv-example-row mt-3">
      <b-row class="mb-1">
        <b-col class="text-right">
          <br />
          <b-button variant="outline-primary" @click="moveWrite()"
            >글쓰기</b-button
          >
        </b-col>
      </b-row>
      <b-row>
        <b-col>
          <b-table-simple hover responsive>
            <b-thead
              head-variant="dark"
              style="font-family: 'twayair'; font-size: 14.5pt"
            >
              <b-tr>
                <b-th>글번호</b-th>
                <b-th>제목</b-th>
                <b-th>내용</b-th>
                <b-th>작성자</b-th>
                <b-th>작성일</b-th>
              </b-tr>
            </b-thead>
            <!-- <tbody>
            <notice-list-row
              style="font-family: 'twayair'; font-size: 13pt"
              v-for="(article, index) in articles"
              :key="index"
              v-bind="article"
            />
          </tbody> -->
          </b-table-simple>
        </b-col>
        <!-- <b-col v-else class="text-center">도서 목록이 없습니다.</b-col> -->
      </b-row>
    </b-container>
  </div>
</template>

<script>
export default {};
</script>

<style></style>
