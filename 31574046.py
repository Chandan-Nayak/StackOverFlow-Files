import unittest
from selenium import webdriver


class SeleniumTest(unittest.TestCase):

    def setUp(self):
        self.driver = webdriver.Firefox()
        self.driver.maximize_window()
        self.driver.implicitly_wait(30)

    def test_search_in_python_org(self):
        driver = self.driver
        driver.get("http://stackoverflow.com/questions/31574046")

        for element in driver.find_elements_by_xpath("//*[@id='footer']//../a[contains(.,'Stack')]"):
            print(element.get_attribute('href'))

        print(driver.find_element_by_xpath("//*[text()='Ask Question']").get_attribute('id'))

    def tearDown(self):
        self.driver.quit()
        pass
