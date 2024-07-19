function openTab(event, tabId) {
  let i;
  let tabs = document.getElementsByClassName("tab-content");
  let tabButtons = document.getElementsByClassName("folerTitleBar");

  // 모든 탭 내용 숨기기
  for (i = 0; i < tabs.length; i++) {
    tabs[i].classList.remove("active");
  }

  // 모든 탭 버튼 비활성화
  for (i = 0; i < tabButtons.length; i++) {
    tabButtons[i].classList.remove("active");
  }

  // 선택한 탭 내용 보이기
  document.getElementById(tabId).classList.add("active");

  // 선택한 탭 버튼 활성화
  event.currentTarget.classList.add("active");

  let activeTab = document.getElementById(tabId);
  activeTab.classList.add("active");
  loadTabContent(tabId, activeTab);
}
