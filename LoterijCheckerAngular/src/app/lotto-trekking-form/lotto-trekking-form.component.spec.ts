import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LottoTrekkingFormComponent } from './lotto-trekking-form.component';

describe('LottoTrekkingFormComponent', () => {
  let component: LottoTrekkingFormComponent;
  let fixture: ComponentFixture<LottoTrekkingFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LottoTrekkingFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LottoTrekkingFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
